package com.dda.assignment.service;

import com.dda.assignment.dto.*;
import com.dda.assignment.repository.ComplaintRepository;
import com.dda.assignment.repository.CustomerComplaintsRepository;
import com.dda.assignment.repository.CustomerRepository;
import com.dda.assignment.repository.ServicePersonRepository;
import com.dda.assignment.service.dto.GetComplaintResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.ObjectUtils;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service(value = "complaintsService")
@Transactional
public class ComplaintsService {

    @Autowired
    private CustomerComplaintsRepository customerComplaintsRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServicePersonRepository servicePersonRepository;

    public CustomerComplaints getComplaintById(BigInteger complaintId) {
        Optional<CustomerComplaints> complaintOpt = customerComplaintsRepository.findByComplaintId(complaintId);
        if(complaintOpt.isPresent()) {
            CustomerComplaints complaint = complaintOpt.get();
            return complaint;
        }
        return null;
    }

    public List<CustomerComplaints> getComplaintsForContactNumber(String contactNumber) {
        Optional<List<CustomerComplaints>> complaintOpt = customerComplaintsRepository.findByContactNumber(contactNumber);
        if(complaintOpt.isPresent()) {
            List<CustomerComplaints> complaints = complaintOpt.get();
            return complaints;
        }
        return null;
    }

    public CustomerComplaints addComplaint(ComplaintRequest complaintRequest) {
        Complaint complaint = new Complaint();
        complaint.setDate(complaintRequest.getDate());
        complaint.setDescription(complaintRequest.getDescription());
        complaint.setResolutionStatus("NOT_STARTED");
        Complaint complaintSaved = complaintRepository.save(complaint);

        Optional<Customer> customer = customerRepository.findById(complaintRequest.getCustomerId());

        CustomerComplaints customerComplaint = new CustomerComplaints();
        customerComplaint.setComplaintId(complaintSaved);
        customerComplaint.setCustomerId(customer.get());
        customerComplaint.setContactNumber(complaintRequest.getContactNumber());

        customerComplaint = customerComplaintsRepository.save(customerComplaint);
        return customerComplaint;
    }

    public CustomerComplaints updateComplaint(BigInteger complaintId, EditComplaintRequest complaintRequest) {
        CustomerComplaints customerComplaint = null;
        Optional<Complaint> complaintOptional = complaintRepository.findById(complaintId);
        Optional<CustomerComplaints> customerComplaintOpt = customerComplaintsRepository.findByComplaintId(complaintId);

        if(complaintOptional.isPresent() && customerComplaintOpt.isPresent()) {
            customerComplaint = customerComplaintOpt.get();
            Complaint complaint = complaintOptional.get();
            if(StringUtils.hasText(complaintRequest.getComments()))
                complaint.setComments(complaintRequest.getComments());
            if(StringUtils.hasText(complaintRequest.getStatus())) {
                complaint.setResolutionStatus(complaintRequest.getStatus());
            }
            complaintRepository.save(complaint);
            if(complaintRequest.getServicePersonId() != null) {
                Optional<ServicePerson> servicePersonOpt = servicePersonRepository.findById(complaintRequest.getServicePersonId());
                if (servicePersonOpt.isPresent()) {
                    customerComplaint.setServicePersonId(servicePersonOpt.get());
                    customerComplaint = customerComplaintsRepository.save(customerComplaint);
                }
            }
        }
        return customerComplaint;

    }
}
