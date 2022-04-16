package com.dda.assignment.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "customer_plans")
@IdClass(CustomerPlansId.class)
@Getter
@Setter
@EqualsAndHashCode
public class CustomerPlans implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Column(name = "subscribed_on")
    LocalDate subscribedOn;

    @Column(name = "expire_on")
    LocalDate expireOn;

    @Column(name = "data_remaining")
    Double dataRemaining;

}
