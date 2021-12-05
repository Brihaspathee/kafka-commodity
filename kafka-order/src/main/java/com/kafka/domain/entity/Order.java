package com.kafka.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:21 AM
 * Project: commodity
 * Package Name: com.kafka.order.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int orderId;

    @Column(nullable = false, length = 20)
    private String orderNumber;

    @Column(nullable = false, length = 200)
    private String orderLocation;

    @Column(nullable = false)
    private LocalDateTime orderDateTime;

    @Column(nullable = false, length = 20)
    private String creditCardNumber;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderLocation='" + orderLocation + '\'' +
                ", orderDateTime=" + orderDateTime +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                '}';
    }
}
