package com.dda.assignment.repository;

import com.dda.assignment.dto.Customer;
import com.dda.assignment.dto.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, String> {
}
