package com.practice.ddd.domain.order.service;

import com.practice.ddd.domain.order.domain.value.OrderSummary;
import com.practice.ddd.domain.order.domain.value.OrderSummary_;
import java.time.LocalDateTime;
import java.util.function.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class SpecificationSummarySpec implements SpecificationSummary<OrderSummary> {
  private String ordererId;

  public SpecificationSummarySpec(String ordererId) {
    this.ordererId = ordererId;
  }

  public static SpecificationSummary<OrderSummary> ordererId(String ordererId) {
    return (Root<OrderSummary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
        (Predicate) cb.equal(root.<String>get("ordererId"), ordererId);
  }

  public static SpecificationSummary<OrderSummary> orderDateBetween(
      LocalDateTime from, LocalDateTime to) {
    return (Root<OrderSummary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
            (Predicate) cb.between(root.get(OrderSummary_.orderDate), from, to);
  }

  @Override
  public Predicate toPredicate(
      Root<OrderSummary> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
    return (Predicate) cb.equal(root.<String>get(OrderSummary_.ordererId), ordererId);
  }
}
