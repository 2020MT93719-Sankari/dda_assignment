package com.dda.assignment.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "plan")
@Getter
@Setter
@EqualsAndHashCode
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;

    @Column(name = "name")
    String name;

    @Column(name = "validity_days")
    Integer validityDays;

    @Column(name = "amount")
    Integer amount;

    @Column(name = "type")
    String type;

    @Column(name = "data")
    Double data;

}
