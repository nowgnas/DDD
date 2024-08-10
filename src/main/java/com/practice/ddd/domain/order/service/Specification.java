package com.practice.ddd.domain.order.service;

import java.io.Serializable;

public interface Specification<T> extends Serializable {
  boolean isSatisfiedBy(T agg);
}
