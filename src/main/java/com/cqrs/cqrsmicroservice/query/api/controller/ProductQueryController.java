package com.cqrs.cqrsmicroservice.query.api.controller;

import java.util.List;

import com.cqrs.cqrsmicroservice.command.api.model.ProductRestModel;
import com.cqrs.cqrsmicroservice.query.api.query.GetProductQuery;

import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductQueryController {

    private QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }



    @GetMapping
    public List<ProductRestModel> getProducts() {
        GetProductQuery getProductQuery = new GetProductQuery();

        List<ProductRestModel> productRestModels = queryGateway.query(
                getProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productRestModels;
    }
    
}
