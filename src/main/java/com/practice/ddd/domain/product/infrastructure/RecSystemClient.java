package com.practice.ddd.domain.product.infrastructure;

import com.practice.ddd.domain.product.entity.Product;
import com.practice.ddd.domain.product.facade.TranslateProducts;
import com.practice.ddd.domain.product.infrastructure.client.ExternalCouponClient;
import com.practice.ddd.domain.product.infrastructure.client.ExternalRecClient;
import com.practice.ddd.domain.product.repository.ProductRepository;
import com.practice.ddd.domain.product.service.ProductRecommendationService;
import com.practice.ddd.domain.product.value.ProductCouponItem;
import com.practice.ddd.domain.product.value.ProductId;
import com.practice.ddd.domain.product.value.RecommendationItem;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecSystemClient implements ProductRecommendationService {
  private final ProductRepository productRepository;
  private final ExternalRecClient externalRecClient;
  private final ExternalCouponClient externalCouponClient;
  private final TranslateProducts translateProducts;

  @Override
  public List<Product> getRecommendationOf(ProductId id) {
    List<RecommendationItem> items = getRecItems(id.getValue());
    List<ProductCouponItem> couponItems = getProductCoupons(id.getValue());

    return translateProducts.toProducts(items, couponItems);
  }

  private List<ProductCouponItem> getProductCoupons(String itemId) {
    return externalCouponClient.getCouponse(itemId);
  }

  private List<Product> toProducts(List<RecommendationItem> items) {
    return items.stream()
        .map(item -> toProductId(item.getItemId()))
        .map(productRepository::findById)
        .collect(Collectors.toList());
  }

  private ProductId toProductId(String itemId) {
    return ProductId.getValue(itemId);
  }

  private List<RecommendationItem> getRecItems(String itemId) {
    return externalRecClient.getRecs(itemId);
  }
}
