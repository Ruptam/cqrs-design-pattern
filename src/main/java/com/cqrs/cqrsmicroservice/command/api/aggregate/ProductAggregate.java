package com.cqrs.cqrsmicroservice.command.api.aggregate;

import com.cqrs.cqrsmicroservice.command.api.commands.CreateProductCommand;
import com.cqrs.cqrsmicroservice.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private long quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        //validations can be done over here.
        //after validation create createProductEvent

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);

        //now publish
        AggregateLifecycle.apply(productCreatedEvent);
    }

    public ProductAggregate() {
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        this.productId = productCreatedEvent.getProductId();
        this.name = productCreatedEvent.getName();
        this.quantity = productCreatedEvent.getQuantity();
        this.price = productCreatedEvent.getPrice();
    }
}
