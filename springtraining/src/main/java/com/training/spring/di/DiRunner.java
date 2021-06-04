package com.training.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DiRunner implements CommandLineRunner {

    @Autowired
    private Conversation con;

    @Override
    public void run(final String... argsParam) throws Exception {
        this.con.talk();
    }

}
