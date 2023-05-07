package com.dotorder.DotOrder.service;

import com.dotorder.DotOrder.domain.Cart;
import com.dotorder.DotOrder.domain.Menu;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.dto.CartDto;
import com.dotorder.DotOrder.dto.CartListResponseDto;
import com.dotorder.DotOrder.repository.CartRepository;
import com.dotorder.DotOrder.repository.MenuRepository;
import com.dotorder.DotOrder.repository.UsersRepository;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Duration;
import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class CartService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    CartRepository cartRepository;
    @Transactional
    public Cart saveCart(CartDto cartDto)
    {
        Users user = usersRepository.findById(cartDto.getUser().getIdx())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        Menu menu = menuRepository.findByName(cartDto.getMenu().getName());
        Hibernate.initialize(menu.getStore());
        cartDto.setUser(user);
        cartDto.setMenu(menu);
        cartDto.setCount(cartDto.getCount());
        cartDto.setPrice(cartDto.getMenu().getPrice(), cartDto.getCount());
        Cart cart = cartDto.toEntity();
        cartRepository.save(cart);
        return cart;
    }

    @Transactional
    public List<CartListResponseDto> getCartsByUserId(int userIdx) {
        Users user = usersRepository.findById(userIdx)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        LocalDateTime oneHourAgo = LocalDateTime.now().minus(Duration.ofHours(1));
        List<Cart> carts = cartRepository.findByUserAndCreatedDateAfter(user, oneHourAgo);
        return carts.stream().map(CartListResponseDto::new).collect(Collectors.toList());
    }


}
