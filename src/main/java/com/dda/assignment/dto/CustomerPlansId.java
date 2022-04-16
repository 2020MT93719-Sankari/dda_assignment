package com.dda.assignment.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class CustomerPlansId implements Serializable {

    private BigInteger customer;
    private BigInteger plan;

}
