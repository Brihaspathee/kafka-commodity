package com.kafka.domain.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:19 AM
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
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue
    private int orderItemId;

    @Column(nullable = false, length = 200)
    private String itemName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
