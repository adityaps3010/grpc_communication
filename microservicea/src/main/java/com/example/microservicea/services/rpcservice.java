package com.example.microservicea.services;

import com.example.microservicea.GreetingRequestB;
import com.example.microservicea.GreetingResponse;
import com.example.microservicea.GreetingResponseB;
import com.example.microservicea.GreetingServiceBGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class rpcservice extends GreetingServiceBGrpc.GreetingServiceBImplBase {

    @Override
    public void processNotification (GreetingRequestB request, StreamObserver<GreetingResponseB> responseObserver) {

        String name = request.getName();
        System.out.println("task name is "+name);
        GreetingResponseB response =GreetingResponseB.newBuilder().setMessage("Hello " + name).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void processNotification(GreetingResponseB request) {

    }

}
