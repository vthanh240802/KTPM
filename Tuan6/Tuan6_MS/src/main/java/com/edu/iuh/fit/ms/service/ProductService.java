package com.edu.iuh.fit.ms.service;

import com.edu.iuh.fit.ms.entity.Product;
import com.edu.iuh.fit.ms.model.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);

    boolean delete(Long id);

    Product add(ProductRequest request);

    Product update(Long id, ProductRequest product);

}
