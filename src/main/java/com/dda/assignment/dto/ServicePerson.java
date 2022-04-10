package com.dda.assignment.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ServicePerson implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    java.math.BigInteger id;

    String name;

    String streetName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pinCode", referencedColumnName = "pinCode")
    StateCountry pinCode;

    String emailId;

}
