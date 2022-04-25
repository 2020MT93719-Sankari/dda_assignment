package com.dda.assignment.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
public class ComplaintRequest {

    Date date;

    String description;

    String contactNumber;

    BigInteger customerId;

    String complaintTypeName;

    String servicePersonId;
}
