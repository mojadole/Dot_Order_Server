package com.dotorder.DotOrder.service;

import com.dotorder.DotOrder.domain.Cart;
import com.dotorder.DotOrder.domain.Order;
import com.dotorder.DotOrder.domain.Order_detail;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.repository.CartRepository;
import com.dotorder.DotOrder.repository.OrderDetailRepository;
import com.dotorder.DotOrder.repository.OrderRepository;
import com.dotorder.DotOrder.repository.UsersRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class OrderService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Transactional
    public Order createOrder(int user_idx) {
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        List<Cart> carts = cartRepository.findByUser(user);

        int totalPrice = carts.stream()
                .mapToInt(cart -> cart.getPrice())
                .sum();

        Order order = Order.builder().user(user).price(totalPrice).build();
        orderRepository.save(order);

        List<Order_detail> orderDetails = carts.stream()
                .map(cart -> Order_detail.builder()
                        .order(order)
                        .menu(cart.getMenu())
                        .count(cart.getCount())
                        .build())
                .collect(Collectors.toList());

        orderDetailRepository.saveAll(orderDetails);

        // Clear the user's cart after placing the order
        cartRepository.deleteAll(carts);

        return order;
    }
}
