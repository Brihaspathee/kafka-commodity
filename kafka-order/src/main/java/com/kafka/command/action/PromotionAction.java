package com.kafka.command.action;

import com.kafka.broker.message.PromotionMessage;
import com.kafka.broker.producer.PromotionProducer;
import com.kafka.web.model.PromotionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:26 AM
 * Project: commodity
 * Package Name: com.kafka.command.action
 * To change this template use File | Settings | File and Code Template
 */
@Component
@RequiredArgsConstructor
public class PromotionAction {

    private final PromotionProducer promotionProducer;

    public void publish(PromotionMessage promotionMessage) {
        promotionProducer.publish(promotionMessage);
    }

    public PromotionMessage convertToPromotionMessage(PromotionRequest promotionRequest){
        return PromotionMessage.builder().promotionCode(promotionRequest.getPromotionCode()).build();
    }
}
