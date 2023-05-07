package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository <Cart, Integer>{
    List<Cart> findAllByUserId(int idx);
}
