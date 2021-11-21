package com.cqrs.cqrsmicroservice;

import com.cqrs.cqrsmicroservice.command.api.exception.ProductServiceEventErrorHandler;

import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CqrsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsMicroserviceApplication.class, args);
	}

	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler(
			"product", 
			configuration -> new ProductServiceEventErrorHandler()
		);
	}

}
