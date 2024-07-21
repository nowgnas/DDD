package com.practice.ddd.domain.product.entity;

import com.practice.ddd.domain.product.value.ProductId;
import com.practice.ddd.domain.product.value.ProductInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product {
    private ProductId productId;
    private ProductInfo productInfo;

}
