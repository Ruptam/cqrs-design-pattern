package com.cqrs.cqrsmicroservice.query.api.projection;

import java.util.List;
import java.util.stream.Collectors;

import com.cqrs.cqrsmicroservice.command.api.data.ProductEntity;
import com.cqrs.cqrsmicroservice.command.api.data.ProductRepository;
import com.cqrs.cqrsmicroservice.command.api.model.ProductRestModel;
import com.cqrs.cqrsmicroservice.query.api.query.GetProductQuery;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductProjection {
    
    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> getProduct(GetProductQuery getProductQuery) {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream().map(product -> ProductRestModel
                        .builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build()).collect(Collectors.toList());
    }
}
