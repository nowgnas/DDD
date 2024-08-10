package com.practice.ddd.test.value;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Embeddable
public class Receiver {
  @Column(name = "receiver_name")
  private String name;

  @Column(name = "receiver_phone")
  private String phoneNumber;
}
