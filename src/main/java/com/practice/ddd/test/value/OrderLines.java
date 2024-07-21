package com.practice.ddd.test.value;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderLines {

    private List<OrderLine> lines;

    public Money getTotalAmounts() {
        return null;
    }

    public void changeOrderLines(List<OrderLine> newLines) {
        this.lines = newLines;
    }
}
