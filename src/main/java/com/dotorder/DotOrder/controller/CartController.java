package com.dotorder.DotOrder.controller;


import com.dotorder.DotOrder.domain.Cart;
import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.dto.CartDto;
import com.dotorder.DotOrder.dto.CartListResponseDto;
import com.dotorder.DotOrder.repository.MenuRepository;
import com.dotorder.DotOrder.repository.UsersRepository;
import com.dotorder.DotOrder.service.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Tag(name = "cart", description = "장바구니")
@RequestMapping("/cart")
@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final UsersRepository usersRepository;
    private final MenuRepository menuRepository;

    @PostMapping("/save")
    //하나씩 장바구니에 담는 과정
    public Cart save(@RequestBody CartDto cartDto){
        return cartService.saveCart(cartDto);
    }

    //장바구니 버튼 눌렀을 때 -> 담아둔 리스트 / 유저 번호 받아서, 해당 유저 Idx의 장바구니 가져오기. +시간 포함
    @GetMapping("{idx}/list")
    public ResponseEntity<List<CartListResponseDto>> getUserCarts(@PathVariable int idx){
        List<CartListResponseDto> carts = cartService.getCartsByUserId(idx);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    //장바구니 수량 변경
    @PatchMapping("{idx}/update")
    public ResponseEntity<Cart> update(@PathVariable int idx, @RequestParam String menu_name, @RequestParam  int count){
        Cart updatedCart = cartService.update(idx, menu_name, count);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

}
