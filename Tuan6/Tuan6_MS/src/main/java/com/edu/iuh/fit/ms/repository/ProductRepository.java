package com.edu.iuh.fit.ms.repository;

import com.edu.iuh.fit.ms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
