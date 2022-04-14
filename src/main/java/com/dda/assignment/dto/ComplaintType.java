package com.dda.assignment.dto;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class ComplaintType {

//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    String id;
    @Id
    String name;

    String description;
}
