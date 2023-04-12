package com.dotorder.DotOrder.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@Table(name = "store")
public class Store{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(nullable = false, length = 100)
    @Schema(description = "가게 이름", example = "김밥천국")
    private String name;

    @Column(nullable = false, length = 100)
    @Schema(description = "좌표", example = "(38.4233, 127.342)")
    private String gps;


    @Builder
    public Store(String name, String gps){
        this.name = name;
        this.gps = gps;
    }

}
