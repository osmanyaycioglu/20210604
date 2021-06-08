package com.training.spring.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.clients.MyRestException;
import com.training.spring.order.Order;
import com.training.spring.order.OrderService;

@RestController
@RequestMapping("/api/v1/restaurant/order")
public class OrderRest {

    @Autowired
    private OrderService os;

    @Value("${server.port}")
    private int          port;

    @PostMapping("/place")
    public String place(@RequestBody final Order orderParam) throws MyRestException {
        return this.os.placeOrder(orderParam) + " order : " + this.port;
    }

}
