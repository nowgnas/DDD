package com.practice.ddd.domain.product.factory;

import com.practice.ddd.domain.product.entity.Product;
import com.practice.ddd.domain.product.value.ProductId;
import com.practice.ddd.domain.product.value.ProductInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductFactory {

    public static Product create(ProductId productId, ProductInfo productInfo) {
        return Product.builder()
                .productId(productId)
                .productInfo(productInfo)
                .build();
    }
}
