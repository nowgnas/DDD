package com.practice.ddd.domain.order.repository;

import com.practice.ddd.domain.order.service.Specification;
import com.practice.ddd.test.domain.OrderNo;
import com.practice.ddd.test.entity.Order;
import java.util.List;

public interface OrderRepository {
  Order findById(OrderNo orderNo);

  void save(Order order);

  List<Order> findAll(Specification<Order> spec);
}
