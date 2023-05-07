package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Cart;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.domain.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository <Cart, Integer>{
    List<Cart> findByUserAndCreatedDateAfter(Users user, LocalDateTime dateTime);
    Optional<Cart> findByUserAndMenu(Users user, Menu menu);

    List<Cart> findByUser(Users user);
}
