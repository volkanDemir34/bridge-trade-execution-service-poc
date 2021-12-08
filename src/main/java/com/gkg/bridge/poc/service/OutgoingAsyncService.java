package com.gkg.bridge.poc.service;

import com.gkg.bridge.poc.model.OrderContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OutgoingAsyncService {

    int counter = 20;

    @Async
    void sendAsync(OrderContext orderResponseContext) {


        orderResponseContext.getStreamObserver().onNext(orderResponseContext.getOrderReply());
        orderResponseContext.getStreamObserver().onCompleted();
    }
}
