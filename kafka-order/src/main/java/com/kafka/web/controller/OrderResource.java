package com.kafka.web.controller;

import com.kafka.command.service.interfaces.OrderService;
import com.kafka.web.model.OrderRequest;
import com.kafka.web.model.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 7:43 AM
 * Project: commodity
 * Package Name: com.kafka.order.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
        log.info("Order Request: {}", orderRequest);
        String orderNumber = orderService.saveOrder(orderRequest);
        OrderResponse orderResponse = OrderResponse.builder().orderNumber(orderNumber).build();
        return ResponseEntity.ok().body(orderResponse);
    }
}
