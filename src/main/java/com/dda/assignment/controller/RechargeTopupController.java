package com.dda.assignment.controller;

import com.dda.assignment.dto.CustomerPlans;
import com.dda.assignment.service.RechargeService;
import com.dda.assignment.service.TopupService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping(value = "/plan-manage")
public class RechargeTopupController {
    @Autowired
    private RechargeService rechargeService;

    @Autowired
    private TopupService topupService;

    @PostMapping(value = "/recharge",consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerPlans> rechargePlan(@RequestBody JsonNode obj) {
        BigInteger customerID = obj.get("customerID").bigIntegerValue();
        BigInteger planID = obj.get("planID").bigIntegerValue();

        CustomerPlans customerPlansResponse = rechargeService.rechargePlanByValidity(customerID,planID);

        return new ResponseEntity<>(customerPlansResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/recharge/{customerID}/{planID}", produces = "application/json")
    public ResponseEntity<CustomerPlans> getRechargePlanDetails(@PathVariable BigInteger customerID,
                                                                @PathVariable BigInteger planID) {

        CustomerPlans customerPlansResponse = rechargeService.getRechargeDetails(customerID,planID);

        return new ResponseEntity<>(customerPlansResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/top-up",consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerPlans> topupPlan(@RequestBody JsonNode obj) {
        BigInteger customerID = obj.get("customerID").bigIntegerValue();
        BigInteger planID = obj.get("planID").bigIntegerValue();

        CustomerPlans customerPlansResponse = topupService.topupPlanByData(customerID,planID);

        return new ResponseEntity<>(customerPlansResponse, HttpStatus.OK);
    }
}
