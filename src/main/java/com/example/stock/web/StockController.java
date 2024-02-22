package com.example.stock.web;

import com.example.stock.domain.StockManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
@RestController
public class StockController {

    private StockManager stockManager;

    public StockController(StockManager stockManager) {
        this.stockManager = stockManager;
    }

    @RequestMapping("product")
    @PostMapping
    public ResponseEntity<Boolean> orderProduct(@RequestBody ProductDTO productDTO) {

        if (stockManager.isAvailiable(ProductDTO.to(productDTO))) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }

}
*/