package com.practice.ddd.test.entity;

import com.practice.ddd.test.domain.OrderNo;
import com.practice.ddd.test.value.Address;
import com.practice.ddd.test.value.Money;
import com.practice.ddd.test.value.OrderLine;
import com.practice.ddd.test.value.OrderLines;
import com.practice.ddd.test.value.OrderState;
import com.practice.ddd.test.value.Orderer;
import com.practice.ddd.test.value.Receiver;
import com.practice.ddd.test.value.ShippingInfo;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {

  private OrderNo orderNo;
  private Address address;
  private Money money;
  private Receiver receiver;
  private Money totalAmounts;
  private OrderLines orderLines;
  private ShippingInfo shippingInfo;
  private Orderer orderer;
  private OrderState state;

  private void calculateTotalAmounts() {
    int sum = orderLines.getLines().stream().mapToInt(ol -> ol.getPrice() * ol.getQuantity()).sum();
    this.totalAmounts = Money.builder().value(sum).build();
  }

  public void changeShippingAddress(Address address) {
    verifyNotYetShipped();
    setAddress(address);
  }

  public void changeReceiver(Receiver receiver) {
    verifyNotYetShipped();
    setReceiver(receiver);
  }

  private void setReceiver(Receiver receiver) {
    this.receiver = receiver;
  }

  private void setAddress(Address address) {
    this.address = address;
  }

  public void changeShippingInfo(ShippingInfo newShippingInfo) {
    verifyNotYetShipped();
  }

  private void verifyNotYetShipped() {
    if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
      throw new IllegalStateException();
    }
  }

  private void setMoney(Money money) {
    this.money = money;
  }

  public void changeOrderLines(List<OrderLine> newLines) {
    orderLines.changeOrderLines(newLines);
    this.totalAmounts = orderLines.getTotalAmounts();
  }

  public void shipTo(ShippingInfo newShippingInfo) {}
}
