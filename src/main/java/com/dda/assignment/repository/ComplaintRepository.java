package com.dda.assignment.repository;

import com.dda.assignment.dto.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, java.math.BigInteger>{

}
