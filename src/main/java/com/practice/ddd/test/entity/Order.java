package com.practice.ddd.test.entity;

import com.practice.ddd.test.domain.OrderNo;
import com.practice.ddd.test.value.Orderer;
import com.practice.ddd.test.value.ShippingInfo;
import com.practice.ddd.test.value.Address;
import com.practice.ddd.test.value.Money;
import com.practice.ddd.test.value.OrderLine;
import com.practice.ddd.test.value.OrderLines;
import com.practice.ddd.test.value.Receiver;
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

    private void calculateTotalAmounts() {
        int sum = orderLines.getLines().stream()
                .mapToInt(ol -> ol.getPrice() * ol.getQuantity()).sum();
        this.totalAmounts = Money.builder().value(sum).build();
    }

    public void changeShippingInfo(ShippingInfo shippingInfo) {
        // action something
    }

    private void setMoney(Money money) {
        this.money = money;
    }

    public void changeOrderLines(List<OrderLine> newLines) {
        orderLines.changeOrderLines(newLines);
        this.totalAmounts = orderLines.getTotalAmounts();
    }

    public void shipTo(ShippingInfo newShippingInfo) {

    }
}
