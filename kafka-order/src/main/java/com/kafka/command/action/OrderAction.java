package com.kafka.command.action;

import com.kafka.broker.message.OrderMessage;
import com.kafka.broker.producer.OrderProducer;
import com.kafka.domain.entity.Order;
import com.kafka.domain.entity.OrderItem;
import com.kafka.domain.repository.OrderItemRepository;
import com.kafka.domain.repository.OrderRepository;
import com.kafka.web.model.OrderItemRequest;
import com.kafka.web.model.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 7:45 AM
 * Project: commodity
 * Package Name: com.kafka.order.command.action
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OrderAction {

    private final OrderProducer orderProducer;

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    public Order convertToOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .creditCardNumber(orderRequest.getCreditCardNumber())
                .orderLocation(orderRequest.getOrderLocation())
                .orderDateTime(LocalDateTime.now())
                .orderNumber(RandomStringUtils.randomAlphanumeric(8).toUpperCase())
                .build();
        List<OrderItem> itemList = orderRequest.getItems().stream().map(this::convertToOrderItem).collect(Collectors.toList());
        itemList.forEach(orderItem -> orderItem.setOrder(order));
        order.setItems(itemList);
        return order;
    }

    public void save(Order order) {
        orderRepository.save(order);
        order.getItems().forEach(orderItemRepository::save);
    }

    public void publish(OrderItem item){
        OrderMessage orderMessage = OrderMessage.builder()
                .itemName(item.getItemName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .orderDateTime(item.getOrder().getOrderDateTime())
                .orderLocation(item.getOrder().getOrderLocation())
                .orderNumber(item.getOrder().getOrderNumber())
                .creditCardNumber(item.getOrder().getCreditCardNumber())
                .build();
        orderProducer.publishOrder(orderMessage);
    }

    private OrderItem convertToOrderItem(OrderItemRequest orderItemRequest){
        OrderItem orderItem = OrderItem.builder()
                .itemName(orderItemRequest.getItemName())
                .price(orderItemRequest.getPrice())
                .quantity(orderItemRequest.getQuantity())
                .build();
        return orderItem;
    }
}
