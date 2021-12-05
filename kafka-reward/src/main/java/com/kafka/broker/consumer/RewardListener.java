package com.kafka.broker.consumer;

import com.kafka.broker.message.OrderMessage;
import com.kafka.broker.message.OrderReplyMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 12:35 PM
 * Project: commodity
 * Package Name: com.kafka.broker.consumer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
public class RewardListener {

    @KafkaListener(topics = "t.commodity.order")
    @SendTo("t.commodity.order.reply")
    public OrderReplyMessage listen(ConsumerRecord<String, OrderMessage> consumerRecord){
        Headers headers = consumerRecord.headers();
        OrderMessage orderMessage = consumerRecord.value();
        log.info("Processing Order {}, item {}, credit card number {}",
                orderMessage.getOrderNumber(),
                orderMessage.getItemName(),
                orderMessage.getCreditCardNumber());
        log.info("Headers are:");
        headers.forEach(header -> {
            log.info("key: {}, value: {}", header.key(), new String(header.value()));
        });
        double bonusPercentage = Double.parseDouble(new String(headers.lastHeader("surpriseBonus").value()));
        double bonusAmount = (bonusPercentage / 100) * orderMessage.getPrice() * orderMessage.getQuantity();
        log.info("Surprise Bonus is {}", bonusAmount);
        OrderReplyMessage orderReplyMessage =
                OrderReplyMessage.builder().replyMessage("Order " + orderMessage.getOrderNumber() + "item " + orderMessage.getItemName() + " processed").build();
        return orderReplyMessage;
    }
}
