package com.edu.iuh.fit.ms.utils;


import com.edu.iuh.fit.ms.model.OrderRequest;
import com.edu.iuh.fit.ms.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@RequiredArgsConstructor
public class OrderMessageListener {

    private final OrderService orderService;

    @JmsListener(destination = "product_order")
    public void onMessageReceived(Message encode) throws JMSException, JsonProcessingException {
        TextMessage message = (TextMessage) encode;
        byte[] decodedBytes = Base64.getDecoder().decode(message.getText());
        String decodedData = new String(decodedBytes);

        ObjectMapper objectMapper = new ObjectMapper();
        OrderRequest request = objectMapper.readValue(decodedData, OrderRequest.class);

        System.out.println(request.toString());

        orderService.create(request);
    }




}
