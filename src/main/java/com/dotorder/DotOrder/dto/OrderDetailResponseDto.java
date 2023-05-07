package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Order_detail;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDetailResponseDto {
    private String storeName;
    private String menuName;
    private int count;

    public OrderDetailResponseDto(Order_detail orderDetail) {
        this.storeName = orderDetail.getMenu().getStore().getName();
        this.menuName = orderDetail.getMenu().getName();
        this.count = orderDetail.getCount();
    }
}
