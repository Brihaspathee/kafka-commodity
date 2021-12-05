package com.kafka.web.model;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2021
 * Time: 7:35 AM
 * Project: commodity
 * Package Name: com.kafka.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRequest {

    private String discountCode;

    private int discountPercentage;

    @Override
    public String toString() {
        return "DiscountRequest{" +
                "discountCode='" + discountCode + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
