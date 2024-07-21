package com.practice.ddd.domain.store.entity;

import com.practice.ddd.domain.product.entity.Product;
import com.practice.ddd.domain.product.factory.ProductFactory;
import com.practice.ddd.domain.product.value.ProductId;
import com.practice.ddd.domain.product.value.ProductInfo;
import com.practice.ddd.domain.store.exception.StoreBlockedException;
import com.practice.ddd.domain.store.value.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store {

    private Status status;


    public Product createProduct(ProductId productId, ProductInfo productInfo) {
        if (isBlocked()) throw new StoreBlockedException();
        return ProductFactory.create(productId, productInfo);
    }

    private boolean isBlocked() {
        return this.status.isValue();
    }
}
