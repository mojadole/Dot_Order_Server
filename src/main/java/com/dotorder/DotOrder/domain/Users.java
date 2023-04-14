package com.dotorder.DotOrder.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private int idx;

    @Column(name = "kakao_nickname")
    private String kakao_nickname;

    @Column(name = "kakao_email")
    private String kakao_email;

    @Column(name = "user_role")
    private String user_role;

    @Builder
    public Users(String kakao_nickname, String kakao_email, String user_role ){
        this.kakao_nickname = kakao_nickname;
        this.kakao_email = kakao_email;
        this.user_role = user_role;
    }
}
