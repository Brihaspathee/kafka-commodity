package com.kafka.broker.consumer;

import com.kafka.broker.message.OrderReplyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 11:31 PM
 * Project: commodity
 * Package Name: com.kafka.broker.consumer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
public class OrderReplyListener {

    @KafkaListener(topics = "t.commodity.order.reply")
    public void listen(OrderReplyMessage orderReplyMessage){
        log.info("The reply from the reward service is {}", orderReplyMessage);
    }
}
