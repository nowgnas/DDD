package com.practice.ddd.test.dip;

import com.practice.ddd.test.entity.Customer;
import com.practice.ddd.test.value.Money;
import com.practice.ddd.test.value.OrderLine;
import java.util.List;

public interface RuleDiscounter {

    Money applyRules(Customer customer, List<OrderLine> orderLines);

}
