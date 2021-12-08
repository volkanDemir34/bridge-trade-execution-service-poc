package com.gkg.bridge.poc.service;

import com.gkg.bridge.poc.configuration.AffinityConfiguration;
import com.gkg.bridge.poc.model.OrderContext;

import com.gkg.bridge.poc.proto.OrderReply;
import lombok.RequiredArgsConstructor;
import net.openhft.affinity.AffinityLock;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ExecutionService extends Thread {

    private final BlockingQueue<OrderContext> requestQueue;
    private final BlockingQueue<OrderContext> responseQueue;
    private final AffinityConfiguration affinityConfiguration;

    private double sum = 0;
    private int counter = 0;
    private int warmup = 3;


    @PostConstruct
    public void startThread() {
        setName("TradeExecutorThread");
        start();
    }

    @Override
    public void run() {
        try (AffinityLock ignored = affinityConfiguration.acquireLock("last-1")) {
            while (true) {
                execute();
            }
        }
    }

    private void execute() {
        if (counter == 100) {
            if (warmup <= 0)
                System.out.println(sum / 100);
            counter = 0;
            sum = 0;
            warmup--;

        }
        OrderContext orderContext = null;

        try {
            orderContext = requestQueue.poll(10, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            // Nothing to do
        }

        if (orderContext == null)
            return;


        OrderReply orderResponse = OrderReply.newBuilder()
                .setExecutionPrice(10.000)
                .build();

        orderContext.setOrderReply(orderResponse);
        responseQueue.add(orderContext);

        sum = sum + (System.nanoTime() - orderContext.getTime());
        counter++;
    }
}
