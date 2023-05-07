package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Cart;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.domain.Menu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@NoArgsConstructor
@Getter
public class CartDto {
    @Schema(description = "유저")
    private Users user;
    @Schema(description = "메뉴")
    private Menu menu;
    @Schema(description = "수량", example = "2")
    private int count;

    @Builder
    public CartDto(Users user, Menu menu, int count){
        this.user = user;
        this.menu =menu;
        this.count = count;
    }

    public Cart toEntity(){
        return Cart.builder()
                .user(user)
                .menu(menu)
                .count(count)
                .build();
    }
    public void setUser(Users user) {this.user = user;}
    public void setMenu(Menu menu) {this.menu = menu;}
    public void setCount(int count) {this.count = count;}
}
