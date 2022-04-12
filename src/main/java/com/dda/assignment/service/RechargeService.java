package com.dda.assignment.service;

import com.dda.assignment.dto.Customer;
import com.dda.assignment.dto.CustomerPlans;
import com.dda.assignment.dto.Plan;
import com.dda.assignment.repository.CustomerPlansRepository;
import com.dda.assignment.repository.CustomerRepository;
import com.dda.assignment.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service(value = "rechargeService")
@Transactional
public class RechargeService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerPlansRepository customerPlansRepository;

    @Autowired
    private PlanRepository planRepository;

    public CustomerPlans rechargePlanByValidity(String customerId, String planId, String validityDays){
        Optional<CustomerPlans> optionalCustomerPlans = customerPlansRepository.getCustomerPlansByCustomerIdAndPlanId(customerId,planId);
        CustomerPlans customerPlanDetails = optionalCustomerPlans.orElseThrow(() -> new RuntimeException("No customer plan records found"));

        Optional<Plan> optionalPlans = planRepository.findById(planId);
        Plan planDetails = optionalPlans.orElseThrow(() -> new RuntimeException("No plans found"));

        List<Plan> plans = customerPlanDetails.getPlan();
        List<Customer> customers = customerPlanDetails.getCustomer();

        customerPlanDetails.setExpireOn(customerPlanDetails.getExpireOn().plusDays(Long.parseLong(validityDays)));

        return customerPlanDetails;
    }

    public CustomerPlans getRechargeDetails(String customerId, String planId){
        Optional<CustomerPlans> optionalCustomerPlans = customerPlansRepository.getCustomerPlansByCustomerIdAndPlanId(customerId,planId);

        return optionalCustomerPlans.orElseThrow(() -> new RuntimeException("No customer plan records found"));
    }
}
