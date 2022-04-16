package com.dda.assignment.repository;

import com.dda.assignment.dto.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PlanRepository extends JpaRepository<Plan, BigInteger> {
}
