package com.practice.ddd.domain.product.value;

import com.practice.ddd.test.value.Money;
import lombok.Getter;

@Getter
public class ProductCreationCommand {
  private String detail;
  private Money price;
}
