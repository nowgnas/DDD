package com.practice.ddd.domain.order.service;

import com.practice.ddd.test.domain.Order;
import lombok.Getter;

@Getter
public class OrderSpec implements Specification<Order> {
  private String ordererId;

  public OrderSpec(String ordererId) {
    this.ordererId = ordererId;
  }

  @Override
  public boolean isSatisfiedBy(Order agg) {

    return agg.getOrdererId().getMemberId().getId().equals(ordererId);
  }
}
