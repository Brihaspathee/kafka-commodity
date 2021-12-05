package com.kafka.command.service.impl;

import com.kafka.command.action.PromotionAction;
import com.kafka.command.service.interfaces.PromotionService;
import com.kafka.web.model.PromotionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:27 AM
 * Project: commodity
 * Package Name: com.kafka.command.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService{

    private final PromotionAction promotionAction;

    @Override
    public void createPromotion(PromotionRequest promotionRequest) {
        promotionAction.publish(promotionAction.convertToPromotionMessage(promotionRequest));
    }
}
