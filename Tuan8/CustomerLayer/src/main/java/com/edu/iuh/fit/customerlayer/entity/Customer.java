package com.edu.iuh.fit.customerlayer.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cust_id;
    @Column(length = 200, nullable = false)
    private String fullName;
    @Column(length = 150, nullable = false, unique = true)
    private String email;
    private String address;
    private String phone;
    private String bankAccNumber;
    private String bankName;


}
