package com.training.spring.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SendResultListener {


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "result-queue",
                                                            autoDelete = "false",
                                                            durable = "false"),
                                             exchange = @Exchange(name = "result-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "send.result"))
    public void handleResult(final String str) {
        System.out.println("Send Result : " + str);
    }

}
