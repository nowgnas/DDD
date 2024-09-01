package com.practice.ddd.domain.product.service;

import com.practice.ddd.domain.product.infrastructure.message.MessageClient;
import java.util.Date;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewLogService {
  private final MessageClient messageClient;

  public void appendViewLog(String memberId, String productId, Date time) {
    messageClient.send(memberId, productId, time);
  }
}
