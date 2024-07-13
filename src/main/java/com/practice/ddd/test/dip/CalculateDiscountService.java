package com.practice.ddd.test.dip;

import com.practice.ddd.test.entity.Customer;
import com.practice.ddd.test.value.Money;
import com.practice.ddd.test.value.OrderLine;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculateDiscountService {

    private final RuleDiscounter ruleDiscounter;

    public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
        Customer customer = Customer.findCustomer(customerId);
        return ruleDiscounter.applyRules(customer, orderLines);
    }

}
