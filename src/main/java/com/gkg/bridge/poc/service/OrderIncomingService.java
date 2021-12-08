package com.gkg.bridge.poc.service;

import com.gkg.bridge.poc.model.OrderContext;
import com.gkg.bridge.poc.proto.OrderReply;
import com.gkg.bridge.poc.proto.OrderRequest;
import com.gkg.bridge.poc.proto.OrderServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;


import java.util.concurrent.BlockingQueue;

@GrpcService
@RequiredArgsConstructor
public class OrderIncomingService extends OrderServiceGrpc.OrderServiceImplBase {

    private final BlockingQueue<OrderContext> requestQueue;

    @Override
    public void processOrder(OrderRequest request, StreamObserver<OrderReply> responseObserver) {

            requestQueue.add(new OrderContext(request, responseObserver));

    }
}
