package com.kafka.command.service.impl;

import com.kafka.broker.message.DiscountMessage;
import com.kafka.command.action.DiscountAction;
import com.kafka.command.service.interfaces.DiscountService;
import com.kafka.web.model.DiscountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 05, December 2021
 * Time: 7:38 AM
 * Project: commodity
 * Package Name: com.kafka.command.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountAction discountAction;

    @Override
    public void createDiscount(DiscountRequest discountRequest) {

        discountAction.publishDiscount(DiscountMessage.builder()
                .discountCode(discountRequest.getDiscountCode())
                .discountPercentage(discountRequest.getDiscountPercentage())
                .build());

    }
}
