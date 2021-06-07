package com.training.spring.payment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.payment.PaymentRequest;
import com.training.spring.payment.PaymentService;

@RestController
@RequestMapping("/api/v1/restaurant/payment")
public class PaymentRest {

    @Autowired
    private PaymentService ps;

    @PostMapping("/pay")
    public String pay(@Validated @RequestBody final PaymentRequest pr) {
        return this.ps.pay(pr);
    }

}
