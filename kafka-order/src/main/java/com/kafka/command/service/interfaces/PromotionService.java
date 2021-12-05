package com.kafka.command.service.interfaces;

import com.kafka.web.model.PromotionRequest;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:26 AM
 * Project: commodity
 * Package Name: com.kafka.command.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface PromotionService {

    void createPromotion(PromotionRequest promotionRequest);
}
