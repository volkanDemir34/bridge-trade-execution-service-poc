package com.gkg.bridge.poc.service;

import com.gkg.bridge.poc.model.OrderContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;

@Service
@RequiredArgsConstructor
public class OrderOutgoingService extends Thread {

    private final BlockingQueue<OrderContext> responseQueue;

    private final OutgoingAsyncService outgoingAsyncService;

    @PostConstruct
    public void startThread() {
        setName("outgoing-thread");
        start();
    }

    @Override
    public void run() {
        while (true) {
            execute();
        }
    }


    private void execute() {
        OrderContext orderContext = responseQueue.poll();
        if (orderContext == null)
            return;
        outgoingAsyncService.sendAsync(orderContext);
    }
}
