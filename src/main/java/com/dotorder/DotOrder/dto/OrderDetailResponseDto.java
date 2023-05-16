package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Order_detail;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDetailResponseDto {
    @Schema(description = "가계 이름", example = "김밥천국")
    private String storeName;
    @Schema(description = "메뉴 이름", example = "참치김밥")
    private String menuName;
    private int count;

    public OrderDetailResponseDto(Order_detail orderDetail) {
        this.storeName = orderDetail.getMenu().getStore().getName();
        this.menuName = orderDetail.getMenu().getName();
        this.count = orderDetail.getCount();
    }
}
