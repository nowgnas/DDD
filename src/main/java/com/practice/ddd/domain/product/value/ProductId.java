package com.practice.ddd.domain.product.value;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ProductId implements Serializable {

  private String value;

  public static ProductId getValue(String itemId) {
    return ProductId.builder().value(itemId).build();
  }
}
