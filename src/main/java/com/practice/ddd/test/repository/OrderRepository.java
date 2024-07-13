package com.practice.ddd.test.repository;

import com.practice.ddd.test.domain.Order;
import com.practice.ddd.test.domain.OrderNo;

public interface OrderRepository {

    Order findByNumber(OrderNo orderNo);

    void save(Order order);

    void delete(Order order);

}
