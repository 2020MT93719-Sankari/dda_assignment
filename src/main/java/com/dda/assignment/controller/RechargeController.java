package com.dda.assignment.controller;

import com.dda.assignment.dto.CustomerPlans;
import com.dda.assignment.dto.Plan;
import com.dda.assignment.service.RechargeService;
import com.fasterxml.jackson.databind.JsonNode;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/plan-manage")
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @PostMapping(value = "/recharge")
    public ResponseEntity<CustomerPlans> rechargePlan(@RequestBody JsonNode obj) {
        String customerID = obj.get("customerID").asText();
        String planID = obj.get("planID").asText();
        String validityDays = obj.get("validityDays").asText();

        CustomerPlans customerPlansResponse = rechargeService.rechargePlanByValidity(customerID,planID,validityDays);

        return new ResponseEntity<>(customerPlansResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/recharge/{customerID}/{planID}")
    public ResponseEntity<CustomerPlans> getRechargePlanDetails(@PathVariable String customerID,
                                                                @PathVariable String planID) {

        CustomerPlans customerPlansResponse = rechargeService.getRechargeDetails(customerID,planID);

        return new ResponseEntity<>(customerPlansResponse, HttpStatus.FOUND);
    }
}
