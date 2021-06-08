package com.training.spring.facade;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.spring.clients.IAccountingClient;
import com.training.spring.clients.MyRestException;
import com.training.spring.order.Order;

@Service
public class PaymentFacade {

    @Autowired
    private RestTemplate      restTemplate;

    @Autowired
    private EurekaClient      client;

    @Autowired
    private IAccountingClient ac;

    @Autowired
    private RabbitTemplate    rt;

    public String pay(final Order orderParam) throws MyRestException {
        PaymentRequest pRequestLoc = new PaymentRequest();
        pRequestLoc.setAmount(100);
        pRequestLoc.setCustomerId(orderParam.getCutomerId());
        String payLoc = this.ac.pay(pRequestLoc);
        Message messageLoc = new Message();
        messageLoc.setDest("3284672364");
        messageLoc.setContent("30 dak içinde siparişiniz size ulaşacak");
        this.rt.convertAndSend("sms-topic-exchange",
                               "send.sms.delivery",
                               messageLoc);
        return payLoc;
    }

    public String pay3(final Order orderParam) {
        PaymentRequest pRequestLoc = new PaymentRequest();
        pRequestLoc.setAmount(100);
        pRequestLoc.setCustomerId(orderParam.getCutomerId());
        String postForObjectLoc = this.restTemplate.postForObject("http://ACCOUNTING/api/v1/restaurant/payment/pay",
                                                                  pRequestLoc,
                                                                  String.class);
        return postForObjectLoc;

    }

    public String pay2(final Order orderParam) {
        PaymentRequest pRequestLoc = new PaymentRequest();
        pRequestLoc.setAmount(100);
        pRequestLoc.setCustomerId(orderParam.getCutomerId());

        Application applicationLoc = this.client.getApplication("ACCOUNTING");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc.toString());
        }
        InstanceInfo iLoc = instancesLoc.get(0);
        RestTemplate restTemplateLoc = new RestTemplate();
        String postForObjectLoc = restTemplateLoc.postForObject("http://"
                                                                + iLoc.getIPAddr()
                                                                + ":"
                                                                + iLoc.getPort()
                                                                + "/api/v1/restaurant/payment/pay",
                                                                pRequestLoc,
                                                                String.class);
        return postForObjectLoc;

    }

}
