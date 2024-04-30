package com.edu.iuh.fit.customerlayer.service.impl;

import com.edu.iuh.fit.customerlayer.entity.Customer;
import com.edu.iuh.fit.customerlayer.repository.CustomerRepository;
import com.edu.iuh.fit.customerlayer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getInfo(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
