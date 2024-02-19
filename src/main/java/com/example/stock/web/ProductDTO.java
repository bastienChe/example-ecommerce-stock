package com.example.stock.web;

import com.example.stock.domain.Product;

public record ProductDTO(int id, String name, int quantity) {
    public static Product to(ProductDTO productDTO) {
        return new Product(productDTO.id(), productDTO.name(), productDTO.quantity());
    }
}
