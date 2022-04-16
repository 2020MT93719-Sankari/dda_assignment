package com.dda.assignment.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class CustomerComplaints implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    java.math.BigInteger id;

    @Column(unique=true)
    @JoinColumn(name = "complaint_id", referencedColumnName = "complaint_id")
    Complaint complaintId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "complaint_type_name", referencedColumnName = "name")
    ComplaintType complaintTypeName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_person_id", referencedColumnName = "id")
    ServicePerson servicePersonId;
}
