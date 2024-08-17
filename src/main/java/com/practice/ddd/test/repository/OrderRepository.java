package com.practice.ddd.test.repository;

import com.practice.ddd.test.domain.Order;
import com.practice.ddd.test.domain.OrderNo;
import com.practice.ddd.test.value.OrderId;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {

    Order findByNumber(OrderNo orderNo);

    void save(Order order);

    void delete(Order order);

    com.practice.ddd.domain.order.domain.entity.Order findById(OrderId id);
}
