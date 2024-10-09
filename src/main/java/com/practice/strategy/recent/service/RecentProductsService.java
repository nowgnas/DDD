package com.practice.strategy.recent.service;

import com.practice.strategy.recent.context.RecentProductsStrategyContext;
import com.practice.strategy.recent.model.value.RequestModel;
import com.practice.strategy.recent.strategy.LoginRecentProductStrategy;
import com.practice.strategy.recent.strategy.NonLoginRecentProductStrategy;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecentProductsService {
  private final RecentProductsStrategyContext recentProductsStrategyContext;
  private final NonLoginRecentProductStrategy nonLoginRecentProductStrategy;
  private final LoginRecentProductStrategy loginRecentProductStrategy;

  public List<Object> getRecentProducts(HttpServletRequest request, RequestModel requestModel) {
    if (isLogin()) {
      requestModel.setMemberNo(getLoginMbNo());
      recentProductsStrategyContext.setRecentViewedProductsStrategy(loginRecentProductStrategy);
    } else {
      requestModel.setMemberNo(getNonLoginMemberNo(request));
      recentProductsStrategyContext.setRecentViewedProductsStrategy(nonLoginRecentProductStrategy);
    }
    return recentProductsStrategyContext.getRecentProducts();
  }

  private String getNonLoginMemberNo(HttpServletRequest request) {
    return "";
  }

  private String getLoginMbNo() {
    return "";
  }

  private boolean isLogin() {
    return false;
  }
}
