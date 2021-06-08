package com.training.spring.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.spring.facade.PaymentRequest;

@FeignClient(value = "ACCOUNTING")
@RequestMapping("/api/v1/restaurant/payment")
public interface IAccountingClient {

    @PostMapping("/pay")
    public String pay(@RequestBody final PaymentRequest pr) throws MyRestException;
}
