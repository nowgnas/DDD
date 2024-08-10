package com.practice.ddd.domain.product.service;

import com.practice.ddd.domain.product.entity.Product;
import com.practice.ddd.domain.product.repository.ProductRepository;
import com.practice.ddd.domain.product.value.NewProductRequest;
import com.practice.ddd.domain.product.value.ProductId;
import com.practice.ddd.domain.store.entity.Store;
import com.practice.ddd.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterProductService {

  private final StoreRepository storeRepository;
  private final ProductRepository productRepository;

  public ProductId registerNewProduct(NewProductRequest req) {
    Store store = storeRepository.findById(req.getStoreId()).orElseThrow(NullPointerException::new);
    ProductId id = productRepository.nextId();
    Product product = store.createProduct(id, req.getProductInfo());
    productRepository.save(product);
    return id;
  }

  public void removeOptions(ProductId id, int optIdxToBeDeleted) {
    // 컬렉션은 지연로딩으로 설정하면 Options는 로딩하지 않음
    Product product = productRepository.findById(id);
    // 트랜잭션 범위이므로 지연 로딩으로 설정한 연관 로딩 가능
    product.removeOptions(optIdxToBeDeleted);
  }
}
