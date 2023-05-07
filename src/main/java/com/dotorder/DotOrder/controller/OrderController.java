package com.dotorder.DotOrder.controller;

import com.dotorder.DotOrder.domain.Order;
import com.dotorder.DotOrder.dto.OrderResponseDto;
import com.dotorder.DotOrder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("{order_idx}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable int order_idx) {
        OrderResponseDto orderResponseDto = orderService.getOrderById(order_idx);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{user_idx}/orders")
    public ResponseEntity<List<OrderResponseDto>> getUserOrders(@PathVariable int user_idx) {
        List<OrderResponseDto> orders = orderService.getOrdersByUserId(user_idx);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
