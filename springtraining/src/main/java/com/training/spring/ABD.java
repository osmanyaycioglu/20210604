package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import a.b.c.Xyz;

public class ABD {

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringtrainingApplication.class,
                                                                       args);
        Xyz xyzLoc = (Xyz) context.getBean("xyz");
        xyzLoc.exec();
        //        Xyz xyzLoc = new Xyz(new MyOtherBean());
        //        xyzLoc.exec();
    }

}
