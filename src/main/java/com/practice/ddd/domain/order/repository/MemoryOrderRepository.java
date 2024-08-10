package com.practice.ddd.domain.order.repository;

import com.practice.ddd.domain.order.service.Specification;
import com.practice.ddd.test.domain.OrderNo;
import com.practice.ddd.test.entity.Order;
import java.util.ArrayList;
import java.util.List;

public class MemoryOrderRepository implements OrderRepository {

  @Override
  public List<Order> findAll(Specification<Order> spec) {
    List<Order> allOrders = findAll();
    return allOrders.stream().filter(spec::isSatisfiedBy).toList();
  }

  private List<Order> findAll() {
    return new ArrayList<>();
  }

  @Override
  public Order findById(OrderNo orderNo) {
    return null;
  }

  @Override
  public void save(Order order) {}
}
