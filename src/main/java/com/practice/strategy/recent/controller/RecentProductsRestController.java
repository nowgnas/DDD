package com.practice.strategy.recent.controller;

import com.practice.strategy.recent.model.value.RequestModel;
import com.practice.strategy.recent.service.RecentProductsService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecentProductsRestController {
  private final RecentProductsService recentProductsService;

  @GetMapping("recent/products")
  public ResponseEntity<Object> getRecentProducts(HttpServletRequest request) {
    List<Object> list = recentProductsService.getRecentProducts(request, new RequestModel());
    return null;
  }
}
