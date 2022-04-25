package com.dda.assignment.repository;

import com.dda.assignment.dto.CustomerComplaints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface CustomerComplaintsRepository  extends JpaRepository<CustomerComplaints, java.math.BigInteger> {

    @Query(value = "SELECT * FROM customer_complaints WHERE complaint_id=?1", nativeQuery = true)
    Optional<CustomerComplaints> findByComplaintId(BigInteger complaintId);

    @Query(value = "SELECT * FROM customer_complaints WHERE contact_number=?1", nativeQuery = true)
    Optional<List<CustomerComplaints>> findByContactNumber(String contactNumber);
}
