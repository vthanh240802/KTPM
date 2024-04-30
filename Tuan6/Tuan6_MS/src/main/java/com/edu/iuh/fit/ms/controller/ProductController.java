package com.edu.iuh.fit.ms.controller;

import com.edu.iuh.fit.ms.entity.Product;
import com.edu.iuh.fit.ms.model.ProductRequest;
import com.edu.iuh.fit.ms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest request){
        return ResponseEntity.ok(productService.add(request));
    }
}
