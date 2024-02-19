package com.example.stock.repository;

import com.example.stock.domain.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class ProductEntity {
    int id;
    String name;

    public static ProductEntity from(Product product) {
        return new ProductEntity(product.getId(), product.getName());
    }
}
