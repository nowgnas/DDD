package com.practice.ddd.domain.product.repository;

import com.practice.ddd.domain.product.entity.Product;
import com.practice.ddd.domain.product.value.ProductId;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {

    ProductId nextId();

    void save(Product product);

}
