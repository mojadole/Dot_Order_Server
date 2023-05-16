package com.dotorder.DotOrder.controller;

import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.dto.StoreDto;
import com.dotorder.DotOrder.dto.UsersDto;
import com.dotorder.DotOrder.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "users", description = "유저")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersControllor {
    private final UsersService usersService;
    @PostMapping("/signup")
    @Operation(summary = "users/signup", description = "회원가입")
    public int save(@RequestBody UsersDto usersDto){
        return usersService.saveUsers(usersDto);
    }

    @GetMapping("/{idx}")
    @Operation(summary = "users/1", description = "유저 정보")
    public Users findById(@PathVariable int idx) {return usersService.findById(idx);}

}
