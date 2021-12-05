package com.kafka.broker.message;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:14 AM
 * Project: commodity
 * Package Name: com.kafka.broker.message
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionMessage {

    private String promotionCode;

    @Override
    public String toString() {
        return "PromotionMessage{" +
                "promotionCode='" + promotionCode + '\'' +
                '}';
    }
}
