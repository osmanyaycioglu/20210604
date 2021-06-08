package com.training.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue",
                                                            autoDelete = "false",
                                                            durable = "false"),
                                             exchange = @Exchange(name = "sms-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "send.sms"))
    public void handleRabbitMessage(final Message stringParam) {
        System.out.println("Received SMS : " + stringParam);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "email-queue",
                                                            autoDelete = "false",
                                                            durable = "false"),
                                             exchange = @Exchange(name = "sms-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "false",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "send.email"))
    public void handleRabbitMessage2(final Message stringParam) {
        System.out.println("Received EMAIL : " + stringParam);
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "message-topic-queue",
                                                            autoDelete = "false",
                                                            durable = "false"),
                                             exchange = @Exchange(name = "sms-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.#"))
    public void handleRabbitMessage3(final Message stringParam) {
        System.out.println("Received ALL TOPIC : " + stringParam);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-topic-queue",
                                                            autoDelete = "false",
                                                            durable = "false"),
                                             exchange = @Exchange(name = "sms-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.sms.#"))
    @SendTo("result-exchange/send.result")
    public String handleRabbitMessage4(final Message stringParam) {
        System.out.println("Received SMS TOPIC : " + stringParam);
        return "SMS Message Processed : " + stringParam;
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "email-topic-queue",
                                                            autoDelete = "false",
                                                            durable = "false"),
                                             exchange = @Exchange(name = "sms-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "false",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "send.email.#"))
    @SendTo("result-exchange/send.result")
    public String handleRabbitMessage5(final Message stringParam) {
        System.out.println("Received EMAIL TOPIC : " + stringParam);
        return "EMAIL Message Processed : " + stringParam;
    }

}
