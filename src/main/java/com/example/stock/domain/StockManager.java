package com.example.stock.domain;

import org.springframework.stereotype.Service;

@Service
public interface StockManager {

    boolean isAvailiable(Product product);

}
