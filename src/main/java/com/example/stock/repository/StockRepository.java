package com.example.stock.repository;

import com.example.stock.domain.Product;
import org.springframework.stereotype.Service;

@Service
public interface StockRepository {

    boolean isAvailaible(Product product);

}
