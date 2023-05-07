package com.dotorder.DotOrder.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(nullable = false, length = 15)
    @Schema(description = "아이디", example = "abc")
    private String id;

    @Column(nullable = false, length = 20)
    @Schema(description = "비밀번호", example = "a1234")
    private String password;

    @Column(nullable = false, length = 15)
    @Schema(description = "상태", example = "guest")
    private String status;

    @Builder
    public Users(String id, String password, String status){
        this.id=id;
        this.password=password;
        this.status=status;
    }
}
