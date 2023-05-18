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
    @Schema(description = "가격", example = "2500")
    private int price;

    @Column
    @Schema(description = "상태", example = "WAIT, DOING, FINISH 중 1")
    private String status;

    @Builder
    public Order(Users user, int price, String status){
        this.user=user;
        this.price= price;
        this.status=status;
    }
    @Override
    public String toString() {
        return "Order{" +
                "idx=" + idx +
                ", user=" + user.getIdx() +
                ", price=" + price +
                ", status='" + status + '\'' +
                // 나머지 필드 추가
                '}';
    }

    public void setStatus(String status) {this.status = status;}

}
