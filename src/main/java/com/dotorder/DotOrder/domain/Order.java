package com.dotorder.DotOrder.domain;

import com.dotorder.DotOrder.BaseTimeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.ConnectionBuilder;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")

public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private Users user;

    @Column
    @Schema(description = "가격")
    private int price;

    @Column
    @Schema(description = "상태")
    private String status;

    @Builder
    public Order(Users user, int price, String status){
        this.user=user;
        this.price= price;
        this.status=status;
    }

}