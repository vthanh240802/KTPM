package com.edu.iuh.fit.customerlayer.service;

import com.edu.iuh.fit.customerlayer.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    Customer getInfo(long id);
    List<Customer> getAll();
}
