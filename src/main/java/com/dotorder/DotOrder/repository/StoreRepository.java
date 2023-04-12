package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
