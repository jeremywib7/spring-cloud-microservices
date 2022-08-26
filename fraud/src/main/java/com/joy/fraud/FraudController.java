package com.joy.fraud;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    @PostMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster() {

    } 
}
