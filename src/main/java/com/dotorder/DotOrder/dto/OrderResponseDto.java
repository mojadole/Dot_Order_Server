package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderResponseDto {
    @Schema(description = "주문 idx", example = "1")
    private int orderIdx;
    @Schema(description = "주문 총 가격", example = "10000")
    private int totalPrice;
    @Schema(description = "주문 현황", example = "WAIT, DOING, FINISH 중 1")
    private String status;
    @Schema(description = "주문 세부 내용", example = "        {\n" +
            "            \"storeName\": \"신전\",\n" +
            "            \"menuName\": \"떡볶이\",\n" +
            "            \"count\": 2\n" +
            "        }")
    private List<OrderDetailResponseDto> orderDetails;

    public OrderResponseDto(Order order, List<OrderDetailResponseDto> orderDetails) {
        this.orderIdx = order.getIdx();
        this.status= order.getStatus();
        this.totalPrice = order.getPrice();
        this.orderDetails = orderDetails;
    }}
