package com.cqrs.cqrsmicroservice.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {

    @AggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private long quantity;
}
