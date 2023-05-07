package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Category;
import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Store;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class MenuOnlyDto {

    @Schema(description = "메뉴 이름", example = "참치김밥")
    private String name;
    @Schema(description = "가격", example = "2500")
    private int price;

    @Schema(description = "카테고리", example = "RICE")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Builder
    public MenuOnlyDto(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category=category;
    }

    public Menu toEntity(){
        return Menu.builder()
                .name(name)
                .price(price)
                .category(category)
                .build();
    }

}
