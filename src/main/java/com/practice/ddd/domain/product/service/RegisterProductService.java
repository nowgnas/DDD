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
        Store store = storeRepository.findById(req.getStoreId())
                .orElseThrow(NullPointerException::new);
        ProductId id = productRepository.nextId();
        Product product = store.createProduct(id, req.getProductInfo());
        productRepository.save(product);
        return id;
    }
}
