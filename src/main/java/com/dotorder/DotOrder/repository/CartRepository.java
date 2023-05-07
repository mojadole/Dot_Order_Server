package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Cart;
import com.dotorder.DotOrder.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CartRepository extends JpaRepository <Cart, Integer>{
    List<Cart> findByUserAndCreatedDateAfter(Users user, LocalDateTime dateTime);

}
