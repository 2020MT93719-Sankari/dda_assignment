package com.dda.assignment.dto;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public class EditComplaintRequest {

    BigInteger servicePersonId;

    String comments;

    String status;
}
