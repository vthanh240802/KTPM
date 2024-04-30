package com.edu.iuh.fit.ms.controller;

import com.edu.iuh.fit.ms.entity.Order;
import com.edu.iuh.fit.ms.model.OrderRequest;
import com.edu.iuh.fit.ms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final JmsTemplate template;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody String encryptedRequest){
        template.convertAndSend("product_order", encryptedRequest);
        return ResponseEntity.ok("Processing");
    }
}
