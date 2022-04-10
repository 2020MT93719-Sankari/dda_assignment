package com.dda.assignment.repository;

import com.dda.assignment.dto.Complaint;
import com.dda.assignment.dto.CustomerComplaints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerComplaintsRepository  extends JpaRepository<CustomerComplaints, java.math.BigInteger> {
}
