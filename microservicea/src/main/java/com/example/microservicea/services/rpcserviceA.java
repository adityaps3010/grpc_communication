package com.example.microservicea.services;

import com.example.microservicea.GreetingRequest;
import com.example.microservicea.GreetingResponse;
import com.example.microservicea.GreetingServiceBGrpc;
import com.example.microservicea.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class rpcserviceA extends GreetingServiceGrpc.GreetingServiceImplBase {

    public void performTask(GreetingRequest request, StreamObserver<GreetingResponse> response)
    {
        String name =request.getName();
        System.out.println("task name is "+name);
        GreetingResponse response1 =GreetingResponse.newBuilder().setMessage("Hello " + name).build();
        response.onNext(response1);

        response.onCompleted();
    }
}
