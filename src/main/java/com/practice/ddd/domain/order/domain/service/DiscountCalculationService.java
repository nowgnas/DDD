package com.practice.ddd.domain.order.domain.service;

import com.practice.ddd.domain.member.domain.value.MemberGrade;
import com.practice.ddd.domain.promotion.model.value.Coupon;
import com.practice.ddd.test.value.Money;
import com.practice.ddd.test.value.OrderLine;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DiscountCalculationService {
  public Money calculateDiscountAmount(
      List<OrderLine> orderLines, List<Coupon> coupons, MemberGrade grade) {
    Money couponDiscount =
        coupons.stream().map(this::calculateDiscount).reduce(new Money(0), Money::add);
    Money memberShipDiscount = calculateDiscount(grade);
    return couponDiscount.add(memberShipDiscount);
  }

  private Money calculateDiscount(MemberGrade grade) {
    return Money.getValue(0);
  }

  private Money calculateDiscount(Coupon coupon) {
    return Money.getValue(0);
  }
}
