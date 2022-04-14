package com.dda.assignment.controller;


import com.dda.assignment.dto.Complaint;
import com.dda.assignment.dto.ComplaintRequest;
import com.dda.assignment.dto.CustomerComplaints;
import com.dda.assignment.dto.EditComplaintRequest;
import com.dda.assignment.service.ComplaintsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintsService complaintsService;

    @RequestMapping(
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<CustomerComplaints> addComplaint(@RequestBody ComplaintRequest complaintRequest) {
        CustomerComplaints complaint = complaintsService.addComplaint(complaintRequest);
        return ResponseEntity.ok(complaint);
    }

    @RequestMapping(value = "/{complaintId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<CustomerComplaints> updateComplaint(@PathVariable("complaintId") BigInteger complaintId, @RequestBody EditComplaintRequest complaintRequest) {
        CustomerComplaints complaint = complaintsService.updateComplaint(complaintId, complaintRequest);
        return ResponseEntity.ok(complaint);
    }

    @RequestMapping(value = "/{complaintId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<CustomerComplaints> getComplaintsForId(@PathVariable("complaintId") String complaintId) {


        BigInteger complaintValue = BigInteger.valueOf(Long.parseLong(complaintId));
        CustomerComplaints response = complaintsService.getComplaintById(complaintValue);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/contactNumber/{contactNumber}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<CustomerComplaints>> getComplaintsForContactNo(@PathVariable("contactNumber") String contactNumber) {

        List<CustomerComplaints> response = complaintsService.getComplaintsForContactNumber(contactNumber);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
        }
        return ResponseEntity.notFound().build();
    }

}
