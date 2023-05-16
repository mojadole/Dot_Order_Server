package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Menu findByName(String name);
    Menu findByNameAndStore(String name, Store store);
}
