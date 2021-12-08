package com.gkg.bridge.poc.service;

import com.gkg.bridge.poc.model.OrderContext;
import org.springframework.stereotype.Service;

@Service
public class OutgoingAsyncService {

    void sendAsync(OrderContext orderResponseContext) {
        orderResponseContext.getStreamObserver().onNext(orderResponseContext.getOrderReply());
        orderResponseContext.getStreamObserver().onCompleted();
        System.out.println("Bitti " + Thread.currentThread().getName());
    }
}
