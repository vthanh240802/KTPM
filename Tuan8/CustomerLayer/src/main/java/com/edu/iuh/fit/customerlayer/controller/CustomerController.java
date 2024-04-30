package com.edu.iuh.fit.customerlayer.controller;

import com.edu.iuh.fit.customerlayer.entity.Customer;
import com.edu.iuh.fit.customerlayer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerServices;

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerServices.create(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getInfo(@PathVariable long id) {
        Customer customer = customerServices.getInfo(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerServices.getAll());
    }

}
