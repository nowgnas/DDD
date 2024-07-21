package com.practice.ddd.domain.store.repository;

import com.practice.ddd.domain.store.entity.Store;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository {

    Optional<Store> findById(String storeId);

}
