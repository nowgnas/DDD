package com.practice.ddd.domain.order.infrastructure;

import com.practice.ddd.domain.order.repository.OrderRepository;
import com.practice.ddd.test.domain.OrderNo;
import com.practice.ddd.test.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class JpaModelRepository implements OrderRepository {

    @Override
    public Order findById(OrderNo orderNo) {
        return null;
    }

    @Override
    public void save(Order order) {

    }
}
