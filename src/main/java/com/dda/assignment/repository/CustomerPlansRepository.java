package com.dda.assignment.repository;

import com.dda.assignment.dto.CustomerPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface CustomerPlansRepository extends JpaRepository<CustomerPlans, java.math.BigInteger> {

    @Query("SELECT cp FROM CustomerPlan WHERE cp.customerId = :customerId AND cp.planId = :planId")
    List<CustomerPlans> getCustomerPlansByCustomerIdAndPlanId(@Param("customerId") BigInteger customerId,
                                                              @Param("planId") BigInteger planId);
}
