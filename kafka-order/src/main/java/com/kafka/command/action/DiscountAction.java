package com.kafka.command.action;

import com.kafka.broker.message.DiscountMessage;
import com.kafka.broker.producer.DiscountProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2021
 * Time: 7:38 AM
 * Project: commodity
 * Package Name: com.kafka.command.action
 * To change this template use File | Settings | File and Code Template
 */
@Component
@RequiredArgsConstructor
public class DiscountAction {

    private final DiscountProducer discountProducer;

    public void publishDiscount(DiscountMessage discountMessage){
        discountProducer.publishDiscount(discountMessage);
    }
}
