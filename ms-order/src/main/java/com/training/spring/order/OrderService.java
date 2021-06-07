package com.training.spring.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.clients.MyRestException;
import com.training.spring.facade.PaymentFacade;

@Service
public class OrderService {

    @Autowired
    private PaymentFacade pf;

    public String placeOrder(final Order order) throws MyRestException {
        return this.pf.pay(order);
    }

}
