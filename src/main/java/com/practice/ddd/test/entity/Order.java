package com.practice.ddd.test.entity;

import com.practice.ddd.test.domain.OrderNo;
import com.practice.ddd.test.value.Address;
import com.practice.ddd.test.value.Money;
import com.practice.ddd.test.value.OrderLine;
import com.practice.ddd.test.value.OrderState;
import com.practice.ddd.test.value.Orderer;
import com.practice.ddd.test.value.Receiver;
import com.practice.ddd.test.value.ShippingInfo;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@Table(name = "order")
@Access(AccessType.PROPERTY)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {
  @EmbeddedId private OrderNo orderNo;
  private Address address;
  private Money money;
  private Receiver receiver;

  @Column(name = "total_amounts")
  private Money totalAmounts; // MoneyConverter를 적용해서 값 반환

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
  @OrderColumn(name = "line_idx")
  private List<OrderLine> orderLines;

  private ShippingInfo shippingInfo;
  private Orderer orderer;
  private OrderState state;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  public OrderState getState() {
    return state;
  }

  public void setState(OrderState state) {
    this.state = state;
  }

  private void calculateTotalAmounts() {
    int sum = orderLines.stream().mapToInt(ol -> ol.getPrice() * ol.getQuantity()).sum();
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

  //  public void changeOrderLines(List<OrderLine> newLines) {
  //    orderLines.changeOrderLines(newLines);
  //    this.totalAmounts = orderLines.getTotalAmounts();
  //  }

  public void shipTo(ShippingInfo newShippingInfo) {}
}
