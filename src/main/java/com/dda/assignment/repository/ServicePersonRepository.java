package com.dda.assignment.repository;

import com.dda.assignment.dto.ServicePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicePersonRepository extends JpaRepository<ServicePerson, java.math.BigInteger> {
}
