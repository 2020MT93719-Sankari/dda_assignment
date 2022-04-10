package com.dda.assignment.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StateCountry {

    @Id
    String pinCode;

    String state;

    String country;
}
