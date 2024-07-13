package com.practice.ddd.test.entity;

import java.util.Objects;

public class Order {

    private String orderNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != Order.class) {
            return false;
        }
        Order other = (Order) o;
        if (this.orderNumber == null) {
            return false;
        }
        return this.orderNumber.equals(other.orderNumber);
    }
}
