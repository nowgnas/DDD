package com.practice.ddd.test.entity;

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
public class Member {

    private ShippingInfo address;
    private Orderer orderer;

    public static Member setOrderer(Orderer orderer) {
        return Member.builder().orderer(orderer).build();
    }

    public void changeAddress(ShippingInfo newShippingInfo) {
        this.address = newShippingInfo;
    }
}
