package com.dda.assignment.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CustomerComplaints implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    java.math.BigInteger id;

    @Column(unique=true)
    @JoinColumn(name = "complaintId", referencedColumnName = "complaintId")
    Complaint complaintId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactNumber", referencedColumnName = "contactNumber")
    CustomerPlans contactNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "complaintTypeName", referencedColumnName = "name")
    ComplaintType complaintTypeName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicePersonId", referencedColumnName = "id")
    ServicePerson servicePersonId;
}
