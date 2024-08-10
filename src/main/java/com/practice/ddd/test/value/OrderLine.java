package com.practice.ddd.test.value;

import com.practice.ddd.domain.product.value.ProductId;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderLine {
  @Embedded private ProductId productId;

  private Address address;
  private Receiver receiver;

  @Column(name = "price")
  private Integer price;

  @Column(name = "quantity")
  private Integer quantity;
}
