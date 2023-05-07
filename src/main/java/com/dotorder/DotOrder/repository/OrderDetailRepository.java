package com.dotorder.DotOrder.repository;

import com.dotorder.DotOrder.domain.Order;
import com.dotorder.DotOrder.domain.Order_detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<Order_detail,Integer> {
}
