package com.dda.assignment.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "customer_plans")
@IdClass(CustomerPlansId.class)
public class CustomerPlans implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Id
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "subscribed_on")
    LocalDate subscribedOn;

    @Column(name = "expire_on")
    LocalDate expireOn;

    @Column(name = "data_remaining")
    Double dataRemaining;


    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDataRemaining(double dataRemaining) {
        this.dataRemaining = dataRemaining;
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

    public Double getDataRemaining() {
        return dataRemaining;
    }

    public void setDataRemaining(Double dataRemaining) {
        this.dataRemaining = dataRemaining;
    }
}
