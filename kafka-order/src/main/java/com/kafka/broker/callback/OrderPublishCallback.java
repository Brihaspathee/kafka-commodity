package com.kafka.broker.callback;

import com.kafka.broker.message.OrderMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;


/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:48 AM
 * Project: commodity
 * Package Name: com.kafka.order.broker.callback
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@Getter
@Setter
public class OrderPublishCallback implements ListenableFutureCallback<SendResult<String, OrderMessage>> {

    private OrderMessage orderMessage;

    @Override
    public void onFailure(Throwable ex) {
        log.error("Unable to publish the order:{}, due to exception {}", orderMessage.getOrderNumber(), ex.getMessage());
    }

    @Override
    public void onSuccess(SendResult<String, OrderMessage> result) {
        log.info("Order that was sent is: {}", orderMessage.getOrderNumber());
        log.info("Order {}, item {}, published successfully", result.getProducerRecord().value().getOrderNumber(),
                result.getProducerRecord().value().getItemName());
    }

}
