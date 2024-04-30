package com.edu.iuh.fit.ms.repository;

import com.edu.iuh.fit.ms.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
