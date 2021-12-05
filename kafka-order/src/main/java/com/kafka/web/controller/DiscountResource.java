package com.kafka.web.controller;

import com.kafka.command.service.interfaces.DiscountService;
import com.kafka.web.model.DiscountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
 * Date: 05, December 2021
 * Time: 7:36 AM
 * Project: commodity
 * Package Name: com.kafka.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/discount")
@RequiredArgsConstructor
public class DiscountResource {

    private final DiscountService discountService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountRequest> createDiscount(@RequestBody DiscountRequest discountRequest){
        discountService.createDiscount(discountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(discountRequest);
    }
}
