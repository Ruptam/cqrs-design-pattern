package com.cqrs.cqrsmicroservice.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ProductEntity {

    @Id
    private String productId;
    private String name;
    private double price;
    private long quantity;
}
