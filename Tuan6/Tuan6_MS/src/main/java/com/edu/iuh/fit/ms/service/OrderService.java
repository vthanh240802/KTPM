package com.edu.iuh.fit.ms.service;

import com.edu.iuh.fit.ms.entity.Order;
import com.edu.iuh.fit.ms.model.OrderRequest;

import java.util.List;

public interface OrderService {
    Order create(OrderRequest request);

    List<Order> getAll();
}
