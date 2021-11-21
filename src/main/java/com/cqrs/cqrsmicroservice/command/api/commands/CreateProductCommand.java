package com.cqrs.cqrsmicroservice.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private long quantity;
}
