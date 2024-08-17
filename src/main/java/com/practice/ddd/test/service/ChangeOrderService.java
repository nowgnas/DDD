package com.practice.ddd.test.service;

import com.practice.ddd.test.entity.Member;
import com.practice.ddd.domain.order.domain.entity.Order;
import com.practice.ddd.test.repository.MemberRepository;
import com.practice.ddd.test.repository.OrderRepository;
import com.practice.ddd.test.value.OrderId;
import com.practice.ddd.test.value.ShippingInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeOrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    public void changeShippingInfo(OrderId id, ShippingInfo newShippingInfo,
            boolean useNewShippingAddrAsMemberAddr) {
        Order order = orderRepository.findById(id);
        order.changeShippingInfo(newShippingInfo);

        order.shipTo(newShippingInfo);
        if (useNewShippingAddrAsMemberAddr) {
            Member member = memberRepository.findById(order.getOrderer().getMemberId().getId());
            member.changeAddress(newShippingInfo);
        }
    }
}
