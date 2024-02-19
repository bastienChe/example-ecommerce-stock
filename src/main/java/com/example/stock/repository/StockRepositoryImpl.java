package com.example.stock.repository;

import com.example.stock.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StockRepositoryImpl implements StockRepository{

    private Map<ProductEntity, Integer> availiableProducts;

    public StockRepositoryImpl() {
        this.availiableProducts = new HashMap<>();
        ProductEntity chairs = new ProductEntity(1, "chaise");
        ProductEntity desks = new ProductEntity(2, "bureau");
        availiableProducts.put(chairs, 4);
        availiableProducts.put(desks, 2);
    }

    @Override
    public boolean isAvailaible(Product product) {

        int desiredQuantity = product.getQuantity();
        ProductEntity productEntity = ProductEntity.from(product);
        int availiableQuantity = this.availiableProducts.get(productEntity);

        if (desiredQuantity <= availiableQuantity) {
            this.availiableProducts.put(productEntity, availiableQuantity - desiredQuantity);
            return true;
        }

        return false;
    }
}
