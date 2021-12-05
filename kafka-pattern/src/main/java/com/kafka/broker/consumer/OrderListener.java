package com.kafka.broker.consumer;

import com.kafka.broker.message.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:08 AM
 * Project: commodity
 * Package Name: com.kafka.broker.consumer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
public class OrderListener {

    @KafkaListener(topics = "t.commodity.order")
    public void listen(OrderMessage orderMessage){
        double totalItemAmount = orderMessage.getPrice() * orderMessage.getQuantity();
        log.info("Processing Order {}, item {}, credit card number {}. Total amount is {}",
                orderMessage.getOrderNumber(),
                orderMessage.getItemName(),
                orderMessage.getCreditCardNumber(),
                totalItemAmount);
    }
}
