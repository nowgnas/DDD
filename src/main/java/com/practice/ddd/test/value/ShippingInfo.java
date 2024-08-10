package com.practice.ddd.test.value;

import javax.persistence.AttributeOverride;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ShippingInfo {
  @Embedded
  @AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zipcode"))
  @AttributeOverride(name = "address1", column = @Column(name = "shipping_address1"))
  @AttributeOverride(name = "address2", column = @Column(name = "shipping_address2"))
  private Address address;

  @Column(name = "shipping_message")
  private String message;

  @Embedded private Receiver receiver;
}
