package com.kafka.broker.producer;

import com.kafka.broker.message.PromotionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:18 AM
 * Project: commodity
 * Package Name: com.kafka.broker.producer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PromotionProducer {

    private final KafkaTemplate<String, PromotionMessage> kafkaTemplate;

    public void publish(PromotionMessage message){
        /**
         * The .send by default method on KafkaTemplate is asynchronous but we can make is
         * synchronous by calling .get() after the send() as shown below
         */
        try {
            SendResult sendResult = kafkaTemplate.send("t.commodity.promotion", message).get();
            /**
             * Send Result can be used for further processing
             */
            log.info("Send Result success for message {}", sendResult.getProducerRecord().value());
        } catch (InterruptedException e) {
            log.error("Error in publishing message {}, because of {}", message, e.getMessage());
            e.printStackTrace();
        } catch (ExecutionException e) {
            log.error("Error in publishing message {}, because of {}", message, e.getMessage());
            e.printStackTrace();
        }
    }
}
