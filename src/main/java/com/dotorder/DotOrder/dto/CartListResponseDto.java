package com.dotorder.DotOrder.dto;


import com.dotorder.DotOrder.domain.Cart;
import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartListResponseDto {

    @Schema(description = "메뉴 이름")
    private String menu_name;
    @Schema(description = "수량", example = "2")
    private int count;
    @Schema(description = "메뉴 총 가격", example = "5000")
    private int price;


    public CartListResponseDto(Cart cart){
        this.menu_name = cart.getMenu().getName();
        this.count = cart.getCount();
        this.price=cart.getPrice();
    }

}
