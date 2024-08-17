package com.practice.ddd.domain.order.domain.value;

import java.time.LocalDateTime;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(OrderSummary.class)
public class OrderSummary_ {
  public static volatile SingularAttribute<OrderSummary, String> number;
  public static volatile SingularAttribute<OrderSummary, Long> version;
  public static volatile SingularAttribute<OrderSummary, String> ordererId;
  public static volatile SingularAttribute<OrderSummary, String> orderName;
  public static volatile SingularAttribute<OrderSummary, LocalDateTime> orderDate;
}
