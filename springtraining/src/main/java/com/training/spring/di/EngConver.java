package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("english")
public class EngConver implements IConversation {

    @Override
    public void sayHello() {
        System.out.println("Hello");

    }

    @Override
    public void sayGoodbye() {
        System.out.println("Goodbye");

    }

}
