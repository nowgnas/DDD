package com.practice.ddd.test.dip;

import com.practice.ddd.test.entity.Customer;
import com.practice.ddd.test.value.Money;
import com.practice.ddd.test.value.OrderLine;
import java.util.List;

public class DroolsRuleDiscounter implements RuleDiscounter{

    @Override
    public Money applyRules(Customer customer, List<OrderLine> orderLines) {
        return null;
    }
}
