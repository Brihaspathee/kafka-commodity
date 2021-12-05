package com.kafka.web.model;

import lombok.*;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 7:43 AM
 * Project: commodity
 * Package Name: com.kafka.order.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private String orderLocation;

    private String creditCardNumber;

    private List<OrderItemRequest> items;

    @Override
    public String toString() {
        return "OrderRequest{" +
                "orderLocation='" + orderLocation + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                '}';
    }
}
