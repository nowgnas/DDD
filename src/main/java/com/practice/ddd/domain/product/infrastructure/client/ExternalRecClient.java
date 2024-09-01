package com.practice.ddd.domain.product.infrastructure.client;

import com.practice.ddd.domain.product.value.RecommendationItem;
import java.util.List;

public interface ExternalRecClient {

    List<RecommendationItem> getRecs(String itemId);
}
