package com.example.microserviceb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.microserviceb.service.rpcService;
@SpringBootApplication
public class MicroservicebApplication {

	@Autowired
	public  rpcService service;

	public static void main(String[] args) {

		SpringApplication.run(MicroservicebApplication.class, args);
	}




}
