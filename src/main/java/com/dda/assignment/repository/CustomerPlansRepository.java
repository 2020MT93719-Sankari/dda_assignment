package com.dda.assignment.repository;

import com.dda.assignment.dto.Customer;
import com.dda.assignment.dto.CustomerPlans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPlansRepository  extends JpaRepository<CustomerPlans, java.math.BigInteger> {
}
