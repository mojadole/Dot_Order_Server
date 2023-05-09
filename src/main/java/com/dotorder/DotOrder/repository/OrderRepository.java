package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Order;
import com.dotorder.DotOrder.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByUser(Users user);

}
