package com.dda.assignment.dto;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class StateCountry {

    @Id
    String pinCode;

    String state;

    String country;

    String city;
}
