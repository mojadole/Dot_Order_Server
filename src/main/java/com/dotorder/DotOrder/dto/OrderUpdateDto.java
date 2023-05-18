package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderUpdateDto {
    private int orderIdx;
    private String status;
    @Builder
    public OrderUpdateDto(int orderIdx, String status){
        this.orderIdx=orderIdx;
        this.status=status;
    }

}
