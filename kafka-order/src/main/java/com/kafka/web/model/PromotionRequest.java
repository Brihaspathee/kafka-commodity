package com.kafka.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:17 AM
 * Project: commodity
 * Package Name: com.kafka.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionRequest {

    private String promotionCode;

    @Override
    public String toString() {
        return "PromotionRequest{" +
                "promotionCode='" + promotionCode + '\'' +
                '}';
    }
}
