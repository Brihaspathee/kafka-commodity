package com.kafka.command.service.interfaces;

import com.kafka.web.model.DiscountRequest;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2021
 * Time: 7:37 AM
 * Project: commodity
 * Package Name: com.kafka.command.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface DiscountService {

    void createDiscount(DiscountRequest discountRequest);
}
