package com.kafka.broker.message;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2021
 * Time: 7:28 AM
 * Project: commodity
 * Package Name: com.kafka.broker.message
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountMessage {

    private String discountCode;

    private int discountPercentage;

    @Override
    public String toString() {
        return "DiscountMessage{" +
                "discountCode='" + discountCode + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
