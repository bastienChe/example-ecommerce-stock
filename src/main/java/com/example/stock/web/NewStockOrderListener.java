package com.example.stock.web;

import com.example.stock.domain.StockManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NewStockOrderListener {

    private ObjectMapper objectMapper;

    private StockManager stockManager;

    public NewStockOrderListener(ObjectMapper objectMapper, StockManager stockManager) {
        this.stockManager = stockManager;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "myQueue")
    public void listenMyQueue(String message) {

        try {
            System.out.println("Message rabbit reçu : " + message);
            ProductDTO productDTO = objectMapper.readValue(message, ProductDTO.class);
            boolean isAvailiable = stockManager.isAvailiable(ProductDTO.to(productDTO));
            System.out.println("disponible ? : " + isAvailiable);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
