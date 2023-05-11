package com.dotorder.DotOrder.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Properties;


@Getter
@Setter
@NoArgsConstructor
@Entity
@DynamicInsert
@Table(name = "menu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "store_idx")
    private Store store;


    @Column(nullable = false, length = 50)
    @Schema(description = "이름", example = "참치김밥")
    private String name;


    @Column(nullable = false)
    @Schema(description = "가격", example = "2500")
    private int price;

    @Builder
    public Menu(Store store,String name, int price){
        this.store = store;
        this.name = name;
        this.price = price;
    }

}

