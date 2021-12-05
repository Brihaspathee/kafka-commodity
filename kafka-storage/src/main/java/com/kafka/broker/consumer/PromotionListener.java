package com.kafka.broker.consumer;

import com.kafka.broker.message.DiscountMessage;
import com.kafka.broker.message.PromotionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:45 AM
 * Project: commodity
 * Package Name: com.kafka.broker.consumer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
@KafkaListener(topics = "t.commodity.promotion")
public class PromotionListener {

    @KafkaHandler
    public void listenForPromotion(PromotionMessage promotionMessage){
        log.info("Processing Promotion: {}", promotionMessage);
    }

    @KafkaHandler
    public void listenForDiscount(DiscountMessage discountMessage){
        log.info("Processing Discount: {}", discountMessage);
    }
}
