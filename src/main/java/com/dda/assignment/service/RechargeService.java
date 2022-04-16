package com.dda.assignment.service;

import com.dda.assignment.dto.Customer;
import com.dda.assignment.dto.CustomerPlans;
import com.dda.assignment.dto.Plan;
import com.dda.assignment.dto.StateCountry;
import com.dda.assignment.repository.CustomerPlansRepository;
import com.dda.assignment.repository.CustomerRepository;
import com.dda.assignment.repository.PlanRepository;
import com.dda.assignment.repository.StateCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
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

    @Autowired
    private StateCountryRepository stateCountryRepository;

    public CustomerPlans rechargePlanByValidity(BigInteger customerId, BigInteger planId) {
        Optional<CustomerPlans> optionalCustomerPlans = customerPlansRepository.getCustomerPlansByCustomerIdAndPlanId(customerId, planId);
        CustomerPlans customerPlanDetails = optionalCustomerPlans.orElseThrow(() -> new RuntimeException("No customer plan records found"));

        Optional<Plan> optionalPlans = planRepository.findById(planId);
        Plan planDetails = optionalPlans.orElseThrow(() -> new RuntimeException("No plans found"));
        Optional<Customer> optionalCustomers = customerRepository.findById(customerId);
        Customer customerDetails = optionalCustomers.orElseThrow(() -> new RuntimeException("No customer found"));

        Optional<StateCountry> optionalStateCountry = stateCountryRepository.findById(customerDetails.getStateCountry().getPinCode());
        StateCountry stateCountryDetails = optionalStateCountry.orElseThrow(() -> new RuntimeException("No location found"));

        customerDetails.setStateCountry(stateCountryDetails);
        customerPlanDetails.setCustomer(customerDetails);

        customerPlanDetails.setExpireOn(customerPlanDetails.getExpireOn().plusDays(planDetails.getValidityDays()));

        return customerPlanDetails;
    }

    public CustomerPlans getRechargeDetails(BigInteger customerId, BigInteger planId) {
        Optional<CustomerPlans> optionalCustomerPlans = customerPlansRepository.getCustomerPlansByCustomerIdAndPlanId(customerId, planId);
        CustomerPlans customerPlanDetails = optionalCustomerPlans.orElseThrow(() -> new RuntimeException("No customer plan records found"));

        Optional<Plan> optionalPlans = planRepository.findById(planId);
        Plan planDetails = optionalPlans.orElseThrow(() -> new RuntimeException("No plans found"));

        Optional<Customer> optionalCustomers = customerRepository.findById(customerId);
        Customer customerDetails = optionalCustomers.orElseThrow(() -> new RuntimeException("No customer found"));

        Optional<StateCountry> optionalStateCountry = stateCountryRepository.findById(customerDetails.getStateCountry().getPinCode());
        StateCountry stateCountryDetails = optionalStateCountry.orElseThrow(() -> new RuntimeException("No location found"));

        customerDetails.setStateCountry(stateCountryDetails);
        customerPlanDetails.setCustomer(customerDetails);

        return customerPlanDetails;
    }
}
