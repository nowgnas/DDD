package com.practice.ddd.test.domain;

import com.practice.ddd.test.value.Orderer;
import com.practice.ddd.test.value.ShippingInfo;
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

    private OrderNo number;
    private Orderer orderer;
    private ShippingInfo shippingInfo;

    public void changeShippingInfo(ShippingInfo shippingInfo) {
        // action something
    }
}
