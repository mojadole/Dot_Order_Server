package com.dotorder.DotOrder.domain;

import com.dotorder.DotOrder.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_idx")
    private Menu menu;

    @Column
    @Schema(description = "수량")
    private int count;

    @Column(nullable = true)
    @Schema(description = "가격")
    private int price;

    @Builder
    public Cart(Users user, Menu menu, int count, int price){
        this.user=user;
        this.menu=menu;
        this.count=count;
        this.price = price;
    }

}
