package com.training.spring.payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${server.port}")
    private int port;

    public String pay(final PaymentRequest pr) {
        return "PAYMENT SUCCESS - " + this.port;
    }

}
