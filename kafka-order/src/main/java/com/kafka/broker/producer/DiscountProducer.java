package com.kafka.broker.producer;

import com.kafka.broker.message.DiscountMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2021
 * Time: 7:41 AM
 * Project: commodity
 * Package Name: com.kafka.broker.producer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DiscountProducer {

    private final KafkaTemplate<String, DiscountMessage> kafkaTemplate;

    public void publishDiscount(DiscountMessage discountMessage){
        kafkaTemplate.send("t.commodity.promotion", discountMessage);
    }
}
