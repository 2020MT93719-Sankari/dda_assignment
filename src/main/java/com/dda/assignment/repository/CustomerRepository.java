package com.dda.assignment.repository;

import com.dda.assignment.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, java.math.BigInteger> {
}
