package com.example.stock.domain;

import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Component;

@Component
public class StockManagerImpl implements StockManager {

    StockRepository stockRepository;

    public StockManagerImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public boolean isAvailiable(Product product) {
        return stockRepository.isAvailaible(product);
    }
}
