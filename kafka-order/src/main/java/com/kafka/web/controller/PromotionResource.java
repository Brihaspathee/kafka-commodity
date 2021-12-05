package com.kafka.web.controller;

import com.kafka.command.service.interfaces.PromotionService;
import com.kafka.web.model.PromotionRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 04, December 2021
 * Time: 7:34 AM
 * Project: commodity
 * Package Name: com.kafka.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/promotion")
@RequiredArgsConstructor
public class PromotionResource {

    private final PromotionService promotionService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createPromotion(@RequestBody PromotionRequest promotionRequest){
        promotionService.createPromotion(promotionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(promotionRequest.getPromotionCode());
    }
}
