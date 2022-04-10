package com.dda.assignment.repository;

import com.dda.assignment.dto.Complaint;
import com.dda.assignment.dto.ComplaintType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintTypeRepository  extends JpaRepository<ComplaintType, String> {
}
