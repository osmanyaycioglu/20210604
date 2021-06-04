package com.training.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Service
//@Repository
//@Controller
//@Configuration

@Component
public class Conversation {

    @Autowired
    @Qualifier("dynamic")
    private IConversation conversation;

    public void talk() {
        System.out.println("--------Talking---------");
        this.conversation.sayHello();
        this.conversation.sayGoodbye();
        System.out.println("--------*******---------");
    }

}
