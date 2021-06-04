package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("esp")
@Qualifier("spanish")
public class EspConver implements IConversation {

    @Override
    public void sayHello() {
        System.out.println("Ola");
    }

    @Override
    public void sayGoodbye() {
        System.out.println("adios");
    }

}
