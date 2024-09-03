package com.example.microserviceb.service;

import com.example.microserviceb.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class rpcService implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        GreetingServiceBGrpc.GreetingServiceBBlockingStub stub = GreetingServiceBGrpc.newBlockingStub(channel);


        GreetingRequestB request = GreetingRequestB.newBuilder().setName("Java").build();

        GreetingResponseB responseB=stub.processNotification(request);


        System.out.println("Response from server: " + responseB.getMessage());
    }
}
