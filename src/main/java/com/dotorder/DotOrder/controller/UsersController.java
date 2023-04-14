package com.dotorder.DotOrder.controller;

import com.dotorder.DotOrder.domain.OauthToken;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService; //(2)

    // 프론트에서 인가코드 받아오는 url
    @GetMapping("/oauth/token") // (3)
    public Users getLogin(@RequestParam("code") String code) { //(4)
        // 넘어온 인가 코드를 통해 access_token 발급 //(5)
        OauthToken oauthToken = usersService.getAccessToken(code);
        Users user = usersService.saveUser(oauthToken.getAccess_token());
        return user;
        //String User = userService.saveUser(oauthToken.getAccess_token());
        //return User;
    }
}
