package com.example.stock.web;

import com.example.stock.domain.StockManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    private StockManager stockManager;

    public StockController(StockManager stockManager) {
        this.stockManager = stockManager;
    }

    @RequestMapping("product")
    @PostMapping
    public ResponseEntity<Boolean> orderProduct(@RequestParam("id") int id,
                                                @RequestParam("name") String name,
                                                @RequestParam("quantity") int quantity) {

        ProductDTO productDTO = new ProductDTO(id, name, quantity);

        if (stockManager.isAvailiable(ProductDTO.to(productDTO))) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }



    }

}
