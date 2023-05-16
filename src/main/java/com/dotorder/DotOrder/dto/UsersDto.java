package com.dotorder.DotOrder.dto;

import com.dotorder.DotOrder.domain.Store;
import com.dotorder.DotOrder.domain.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UsersDto {
    @Schema(description = "아이디", example = "abc")
    private String id;
    @Schema(description = "비밀번호", example = "a1234")
    private String password;
    @Schema(description = "상태", example = "guest")
    private String status;
    @Builder
    public UsersDto(String id, String password, String status) {
        this.id = id;
        this.password = password;
        this.status = status;
    }

    public Users toEntity(){
        return Users.builder()
                .id(id)
                .password(password)
                .status(status)
                .build();
    }
}
