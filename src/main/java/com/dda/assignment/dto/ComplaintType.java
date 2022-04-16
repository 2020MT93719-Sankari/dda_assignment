package com.dda.assignment.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class ComplaintType {

//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    String id;
    @Id
    String name;

    String description;
}
