package com.dda.assignment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class CustomerComplaints implements Serializable {

    public CustomerComplaints() {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20)")
    java.math.BigInteger id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "complaintId", referencedColumnName = "complaintId")
    Complaint complaintId;

    String contactNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    Customer customerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "complaintTypeName", referencedColumnName = "name")
    ComplaintType complaintTypeName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicePersonId", referencedColumnName = "id")
    ServicePerson servicePersonId;
}
