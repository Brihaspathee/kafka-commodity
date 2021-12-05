package com.kafka.web.model;

import lombok.*;

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
public class OrderItemRequest {

    private String itemName;

    private int price;

    private int quantity;

    @Override
    public String toString() {
        return "OrderItemRequest{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
