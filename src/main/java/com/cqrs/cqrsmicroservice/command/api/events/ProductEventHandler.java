package com.cqrs.cqrsmicroservice.command.api.events;

import com.cqrs.cqrsmicroservice.command.api.data.ProductEntity;
import com.cqrs.cqrsmicroservice.command.api.data.ProductRepository;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.axonframework.messaging.interceptors.ExceptionHandler;

@Component
@ProcessingGroup("product")
public class ProductEventHandler {

    private ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) throws Exception {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productCreatedEvent, productEntity);
        productRepository.save(productEntity);
        //throw new Exception("Exception Occured");
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
