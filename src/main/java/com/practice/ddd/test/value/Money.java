package com.practice.ddd.test.value;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money {

  private int value;

  public static Money getValue(Integer value) {
    return Money.builder().value(value).build();
  }

  public Money add(Money money) {
    return Money.builder().value(this.getValue() + money.getValue()).build();
  }

  public Money minus(Money discountAmounts) {
    return Money.getValue(this.value - discountAmounts.value);
  }
}
