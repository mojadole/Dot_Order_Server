package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Category;
import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Store;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
public class MenuDto {
    private Store store;

    @Schema(description = "메뉴 이름", example = "참치김밥")
    private String name;
    @Schema(description = "가격", example = "2500")
    private int price;

    @Schema(description = "카테고리", example = "RICE")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Builder
    public MenuDto(Store store, String name, int price, Category category) {
        this.store = store;
        this.name = name;
        this.price = price;
        this.category=category;
    }

    public Menu toEntity(){
        return Menu.builder()
                .store(store)
                .name(name)
                .price(price)
                .category(category)
                .build();
    }

    public void setStore(Store store) {this.store = store;}


}
