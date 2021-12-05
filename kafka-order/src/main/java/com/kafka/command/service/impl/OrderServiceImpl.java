package com.kafka.command.service.impl;

import com.kafka.command.action.OrderAction;
import com.kafka.command.service.interfaces.OrderService;
import com.kafka.domain.entity.Order;
import com.kafka.web.model.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 7:52 AM
 * Project: commodity
 * Package Name: com.kafka.order.command.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderAction orderAction;

    @Override
    public String saveOrder(OrderRequest orderRequest) {
        // 1. convert order request object to order object
        Order order = orderAction.convertToOrder(orderRequest);

        // 2. Save the order entity to data base
        orderAction.save(order);

        // 3. Flatten the item and order and publish
        order.getItems().forEach(orderAction::publish);

        // 4. return order number
        return order.getOrderNumber();
    }
}
