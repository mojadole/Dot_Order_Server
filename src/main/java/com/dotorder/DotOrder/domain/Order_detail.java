package com.dotorder.DotOrder.domain;

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
@Table(name = "Order_detail")

public class Order_detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_idx")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_idx")
    private Menu menu;

    @Column
    @Schema(description = "수량")
    private int count;

    @Column(nullable = true)
    @Schema(description = "후기")
    private boolean good;

    @Builder
    public Order_detail(Order order, Menu menu, int count, boolean good){
        this.order=order;
        this.menu=menu;
        this.count=count;
        this.good=good;
    }
}
