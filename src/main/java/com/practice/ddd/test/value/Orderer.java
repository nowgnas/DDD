package com.practice.ddd.test.value;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
public class Orderer {
  @Embedded
  @AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "order_id")))
  private MemberId memberId;

  @Column(name = "orderer_name")
  private String name;
}
