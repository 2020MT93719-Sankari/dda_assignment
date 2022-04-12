package com.dda.assignment.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Entity
public class CustomerPlans{

    @EmbeddedId
    public CustomerPlansId id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    List<Plan> plan;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plan")
    List<Customer> customer;

    LocalDate subscribedOn;
    LocalDate expireOn;
    Integer dataRemaining;

    public CustomerPlansId getId() {
        return id;
    }

    public List<Plan> getPlan() {
        return plan;
    }

    public void setPlan(List<Plan> plan) {
        this.plan = plan;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public LocalDate getSubscribedOn() {
        return subscribedOn;
    }

    public void setSubscribedOn(LocalDate subscribedOn) {
        this.subscribedOn = subscribedOn;
    }

    public LocalDate getExpireOn() {
        return expireOn;
    }

    public void setExpireOn(LocalDate expireOn) {
        this.expireOn = expireOn;
    }

    public Integer getDataRemaining() {
        return dataRemaining;
    }

    public void setDataRemaining(Integer dataRemaining) {
        this.dataRemaining = dataRemaining;
    }
}
