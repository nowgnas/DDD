package com.practice.ddd.domain.order.application;

import com.practice.ddd.domain.member.domain.Member;
import com.practice.ddd.domain.order.domain.entity.Order;
import com.practice.ddd.domain.order.domain.value.OrderRequest;
import com.practice.ddd.domain.order.repository.OrderRepository;
import com.practice.ddd.domain.order.domain.service.DiscountCalculationService;
import com.practice.ddd.test.domain.OrderNo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final DiscountCalculationService discountCalculationService;
  private final OrderRepository orderRepository;

  public OrderNo placeOrder(OrderRequest orderRequest) {
    OrderNo orderNo = orderRepository.nextId();
    Order order = createOrder(orderNo, orderRequest);
    orderRepository.save(order);
    return orderNo;
  }

  private Order createOrder(OrderNo orderNo, OrderRequest orderRequest) {
    Member member = findMember(orderRequest.getOrdererId());
    Order order = Order.createOrder(orderNo, orderRequest);
    order.calculateAmounts(this.discountCalculationService, member.getMemberGrade());
    return order;
  }

  private Member findMember(String ordererId) {
    return Member.builder().build();
  }
}
