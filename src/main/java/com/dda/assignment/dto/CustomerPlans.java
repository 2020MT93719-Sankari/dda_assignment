package com.dda.assignment.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CustomerPlans implements Serializable {

    @Id
    java.math.BigInteger contactNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    Customer customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planName", referencedColumnName = "name")
    Plan planName;
}
