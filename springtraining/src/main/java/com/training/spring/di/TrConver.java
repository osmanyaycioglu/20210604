package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("turkish")
public class TrConver implements IConversation {

    @Override
    public void sayHello() {
        System.out.println("Merhaba");

    }

    @Override
    public void sayGoodbye() {
        System.out.println("Güle güle");

    }

}
