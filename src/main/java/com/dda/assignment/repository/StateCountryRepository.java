package com.dda.assignment.repository;

import com.dda.assignment.dto.ServicePerson;
import com.dda.assignment.dto.StateCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateCountryRepository  extends JpaRepository<StateCountry, String> {
}
