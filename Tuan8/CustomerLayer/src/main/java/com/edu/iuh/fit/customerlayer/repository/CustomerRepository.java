package com.edu.iuh.fit.customerlayer.repository;

import com.edu.iuh.fit.customerlayer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
