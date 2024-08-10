package com.practice.ddd.domain.common.jpa;

import com.practice.ddd.test.value.Money;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Money money) {
    return money == null ? null : money.getValue();
  }

  @Override
  public Money convertToEntityAttribute(Integer value) {
    return value == null ? null : Money.getValue(value);
  }
}
