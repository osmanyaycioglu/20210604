package com.training.spring.order;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Order {

    @NotNull
    @Positive
    private Long         cutomerId;
    @Size(min = 1)
    private List<String> orders;

    public Long getCutomerId() {
        return this.cutomerId;
    }

    public void setCutomerId(final Long cutomerIdParam) {
        this.cutomerId = cutomerIdParam;
    }

    public List<String> getOrders() {
        return this.orders;
    }

    public void setOrders(final List<String> ordersParam) {
        this.orders = ordersParam;
    }


}
