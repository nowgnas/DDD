package com.practice.ddd.domain.order.service;

import java.io.Serializable;
import java.util.function.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.lang.Nullable;

public interface SpecificationSummary<T> extends Serializable {
  @Nullable
  Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb);
}
