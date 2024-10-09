package com.practice.strategy.recent.context;

import com.practice.strategy.recent.strategy.RecentViewedProductsStrategy;
import java.util.List;
import lombok.Setter;

@Setter
public class RecentProductsStrategyContext {
  private RecentViewedProductsStrategy recentViewedProductsStrategy;

  public List<Object> getRecentProducts() {
    return recentViewedProductsStrategy.getRecentProducts();
  }
}
