package com.gkg.bridge.poc.model;

import com.gkg.bridge.poc.proto.OrderReply;
import com.gkg.bridge.poc.proto.OrderRequest;
import io.grpc.stub.StreamObserver;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.PrintWriter;


@Data
@NoArgsConstructor
public class OrderContext {

    private OrderRequest orderRequest;
    private OrderReply orderReply;
    private StreamObserver<OrderReply> streamObserver;
    private PrintWriter printWriter;
    private long time;


    public OrderContext(OrderRequest orderRequest, StreamObserver<OrderReply> streamObserver) {
        this.orderRequest = orderRequest;
        this.streamObserver = streamObserver;
        this.time=System.nanoTime();

    }



}
