package com.dotorder.DotOrder.controller;

import com.dotorder.DotOrder.domain.Order;
import com.dotorder.DotOrder.dto.OrderResponseDto;
import com.dotorder.DotOrder.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
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
    @PostMapping("/{user_idx}/place")
    @Operation(summary = "/order/{user_idx}/place", description = "장바구니에 담긴 음식들을 주문하는 api(장바구니 삭제 및 주문)")
    public ResponseEntity<Order> placeOrder(@PathVariable int user_idx) {
        Order order = orderService.createOrder(user_idx);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("{order_idx}")
    @Operation(summary = "/order/{order_idx}", description = "현재 주문한 주문 내역 조회 api")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable int order_idx) {
        OrderResponseDto orderResponseDto = orderService.getOrderById(order_idx);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{user_idx}/orders")
    @Operation(summary = "/order/{user_idx}/orders", description = "유저의 모든 주문내역 히스토리 조회 api")
    public ResponseEntity<List<OrderResponseDto>> getUserOrders(@PathVariable int user_idx) {
        List<OrderResponseDto> orders = orderService.getOrdersByUserId(user_idx);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
