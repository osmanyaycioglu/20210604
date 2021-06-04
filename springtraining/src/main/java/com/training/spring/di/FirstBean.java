package com.training.spring.di;

import org.springframework.stereotype.Component;

@Component
public class FirstBean {


    public FirstBean() {
        System.out.println("First Bean yaratıldı");
    }

    public void hello() {
        System.out.println("hello");
    }

}
