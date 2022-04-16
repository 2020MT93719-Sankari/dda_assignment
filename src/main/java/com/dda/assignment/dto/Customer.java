package com.dda.assignment.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    java.math.BigInteger id;

    @Column(name = "name")
    String name;

    @Column(name = "street_name")
    String streetName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pin_code")
    StateCountry pinCode;

    @Column(name = "email_id")
    String emailId;

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public StateCountry getPinCode() {
        return pinCode;
    }

    public void setPinCode(StateCountry pinCode) {
        this.pinCode = pinCode;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
