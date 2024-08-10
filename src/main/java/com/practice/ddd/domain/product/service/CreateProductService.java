package com.practice.ddd.domain.product.service;

import com.practice.ddd.domain.product.entity.Product;
import com.practice.ddd.domain.product.repository.ProductRepository;
import com.practice.ddd.domain.product.value.ProductCreationCommand;
import com.practice.ddd.domain.product.value.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateProductService {
  private final ProductIdService productIdService;
  private final ProductRepository productRepository;

  @Transactional
  public ProductId createProduct(ProductCreationCommand cmd) {
    ProductId id = productIdService.nextId();
    Product product = Product.getProduct(id, cmd);
    productRepository.save(product);
    return id;
  }
}
