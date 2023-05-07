package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderResponseDto {
    private int orderIdx;
    private int totalPrice;
    private String status;
    private List<OrderDetailResponseDto> orderDetails;

    public OrderResponseDto(Order order, List<OrderDetailResponseDto> orderDetails) {
        this.orderIdx = order.getIdx();
        this.status= order.getStatus();
        this.totalPrice = order.getPrice();
        this.orderDetails = orderDetails;
    }}
