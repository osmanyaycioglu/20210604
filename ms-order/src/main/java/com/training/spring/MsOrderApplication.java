package com.training.spring;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRetry
@EnableRabbit
public class MsOrderApplication {


    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    //    @Bean
    //    public Retryer retryer() {
    //        return new Retryer.Default();
    //    }

    //    @Bean
    //    public LoadBalancedRetryFactory retryFactory() {
    //        return new LoadBalancedRetryFactory() {
    //
    //            @Override
    //            public BackOffPolicy createBackOffPolicy(final String service) {
    //                return new ExponentialBackOffPolicy();
    //            }
    //        };
    //    }

    public static void main(final String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}
