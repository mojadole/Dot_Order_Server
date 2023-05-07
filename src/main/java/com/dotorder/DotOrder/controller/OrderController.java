package com.dotorder.DotOrder.controller;

import com.dotorder.DotOrder.domain.Order;
import com.dotorder.DotOrder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/{idx}/place")
    public ResponseEntity<Order> placeOrder(@PathVariable int idx) {
        Order order = orderService.createOrder(idx);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
