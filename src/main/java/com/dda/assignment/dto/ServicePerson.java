package com.dda.assignment.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ServicePerson implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    java.math.BigInteger id;

    String name;

    @Column(name = "street_name")
    String streetName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pin_code", referencedColumnName = "pin_code")
    StateCountry pinCode;

    @Column(name = "email_id")
    String emailId;

}
