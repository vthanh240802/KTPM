package com.edu.iuh.fit.ms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderRequest {
    private String email;
    private String customerName;
    private String address;
    private Long productId;
    private Integer quantity;
}
