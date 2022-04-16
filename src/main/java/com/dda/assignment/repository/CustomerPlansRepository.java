package com.dda.assignment.repository;

import com.dda.assignment.dto.CustomerPlans;
import com.dda.assignment.dto.CustomerPlansId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.Optional;

public interface CustomerPlansRepository extends JpaRepository<CustomerPlans, CustomerPlansId> {

    @Query(value = "SELECT * FROM customer_plans cp WHERE cp.customer_id = :customerId AND cp.plan_id = :planId", nativeQuery = true)
    Optional<CustomerPlans> getCustomerPlansByCustomerIdAndPlanId(@Param("customerId") BigInteger customerId,
                                                                 @Param("planId") BigInteger planId);
}
