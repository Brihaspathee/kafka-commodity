package com.kafka.broker.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kafka.util.LocalDateTimeDeserializer;
import com.kafka.util.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:31 AM
 * Project: commodity
 * Package Name: com.kafka.order.broker.message
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage {

    private String creditCardNumber;

    private String itemName;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime orderDateTime;

    private String orderLocation;

    private String orderNumber;

    private int price;

    private int quantity;

    @Override
    public String toString() {
        return "OrderMessage{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", itemName='" + itemName + '\'' +
                ", orderDateTime=" + orderDateTime +
                ", orderLocation='" + orderLocation + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
