package com.kafka.domain.repository;

import com.kafka.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, December 2021
 * Time: 6:27 AM
 * Project: commodity
 * Package Name: com.kafka.order.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
