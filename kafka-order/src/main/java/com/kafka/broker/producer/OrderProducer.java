package com.kafka.broker.producer;

import com.kafka.broker.callback.OrderPublishCallback;
import com.kafka.broker.message.OrderMessage;
import com.kafka.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.aspectj.weaver.ast.Or;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:42 AM
 * Project: commodity
 * Package Name: com.kafka.order.broker.producer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderMessage> kafkaTemplate;

    private final OrderPublishCallback orderPublishCallback;

    public void publishOrder(OrderMessage orderMessage){
        orderPublishCallback.setOrderMessage(orderMessage);
        ProducerRecord<String, OrderMessage> producerRecord = buildProducerRecord(orderMessage);
        kafkaTemplate.send(producerRecord).addCallback(orderPublishCallback);
        log.info("just a dummy message for order {}", orderMessage.getOrderNumber());
    }

    private ProducerRecord<String, OrderMessage> buildProducerRecord(OrderMessage orderMessage){
        int surpriseBonus = StringUtils.startsWithIgnoreCase(orderMessage.getOrderLocation(), "A")? 12 : 15;
        List<Header> headers = new ArrayList<>();
        RecordHeader surpriseBonusHeader = new RecordHeader("surpriseBonus", Integer.toString(surpriseBonus).getBytes());
        headers.add(surpriseBonusHeader);
        return  new ProducerRecord<String, OrderMessage>("t.commodity.order", null, orderMessage.getOrderNumber(), orderMessage, headers);
    }
}
