package com.edu.iuh.fit.ms.service.impl;

import com.edu.iuh.fit.ms.entity.Order;
import com.edu.iuh.fit.ms.entity.OrderStatus;
import com.edu.iuh.fit.ms.entity.Product;
import com.edu.iuh.fit.ms.model.OrderRequest;
import com.edu.iuh.fit.ms.repository.OrderRepository;
import com.edu.iuh.fit.ms.repository.ProductRepository;
import com.edu.iuh.fit.ms.service.EmailService;
import com.edu.iuh.fit.ms.service.OrderService;
import com.edu.iuh.fit.ms.service.ProductService;
import com.edu.iuh.fit.ms.utils.EmailTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final EmailService emailService;

    @Override
    public Order create(OrderRequest request) {

        if (request.getProductId() == null
                || request.getQuantity() == null
                || request.getEmail() == null){
            return null;
        }

        Product product = productRepository.findById(request.getProductId()).orElse(null);
        Order order =  Order.builder()
                .email(request.getEmail())
                .customerName(request.getCustomerName())
                .address(request.getAddress())
                .createdAt(LocalDateTime.now())
                .product(product)
                .quantity(request.getQuantity())
                .build();

        if (product == null || product.getQuantity() < request.getQuantity()){
            order.setStatus(OrderStatus.DENIED);
        }else {
            order.setStatus(OrderStatus.ACCEPTED);
            product.setQuantity(product.getQuantity() - request.getQuantity());
            productRepository.save(product);
        }

        order = orderRepository.save(order);


        String emailString = EmailTemplate.createEmailBody(order);
        emailService.sendEmail(order.getEmail(),
                order.getStatus() == OrderStatus.ACCEPTED ? "Đặt hàng thành công" : "Đơn hàng bị từ chối",
                EmailTemplate.createEmailBody(order));

        return order;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
