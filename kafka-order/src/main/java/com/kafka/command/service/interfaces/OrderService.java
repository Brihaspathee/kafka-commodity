package com.kafka.command.service.interfaces;

import com.kafka.web.model.OrderRequest;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 7:45 AM
 * Project: commodity
 * Package Name: com.kafka.order.command.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface OrderService {

    String saveOrder(OrderRequest orderRequest);
}
