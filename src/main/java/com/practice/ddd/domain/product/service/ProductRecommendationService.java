package com.practice.ddd.domain.product.service;

import com.practice.ddd.domain.product.entity.Product;
import com.practice.ddd.domain.product.value.ProductId;
import java.util.List;

public interface ProductRecommendationService {
  List<Product> getRecommendationOf(ProductId id);
}
