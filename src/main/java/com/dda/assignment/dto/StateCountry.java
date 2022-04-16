package com.dda.assignment.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state_country")
@Getter
@Setter
@EqualsAndHashCode
public class StateCountry {

    @Id
    @Column(name = "pin_code")
    String pinCode;

    @Column(name = "state")
    String state;

    @Column(name = "country")
    String country;

}
