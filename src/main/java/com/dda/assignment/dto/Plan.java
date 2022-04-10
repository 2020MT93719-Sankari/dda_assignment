package com.dda.assignment.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plan {

    @Id
    String name;

    int validityDays;

    int amount;
}
