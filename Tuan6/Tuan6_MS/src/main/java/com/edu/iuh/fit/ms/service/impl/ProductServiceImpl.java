package com.edu.iuh.fit.ms.service.impl;

import com.edu.iuh.fit.ms.entity.Product;
import com.edu.iuh.fit.ms.model.ProductRequest;
import com.edu.iuh.fit.ms.repository.ProductRepository;
import com.edu.iuh.fit.ms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        productRepository.deleteById(id);
        return true;

    }

    @Override
    public Product add(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, ProductRequest request) {
        return null;
    }
}
