package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
