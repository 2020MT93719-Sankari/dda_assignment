package com.dda.assignment.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@Getter
@Setter
@EqualsAndHashCode
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    java.math.BigInteger id;

    @Column(name = "name")
    String name;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "street_name")
    String streetName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pin_code")
    StateCountry stateCountry;

}
