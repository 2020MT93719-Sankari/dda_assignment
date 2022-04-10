package com.dda.assignment.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Complaint implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    java.math.BigInteger complaintId;

    Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    Customer customerId;

    String description;

    String resolutionStatus;

    String comments;

}
