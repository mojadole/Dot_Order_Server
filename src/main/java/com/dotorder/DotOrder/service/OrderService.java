package com.dotorder.DotOrder.service;

import com.dotorder.DotOrder.domain.Cart;
import com.dotorder.DotOrder.domain.Order;
import com.dotorder.DotOrder.domain.Order_detail;
import com.dotorder.DotOrder.domain.Users;
import com.dotorder.DotOrder.dto.OrderDetailResponseDto;
import com.dotorder.DotOrder.dto.OrderResponseDto;
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
    @Autowired
    MyHandler myHandler;

    @Transactional
    public Order createOrder(int user_idx) {
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        List<Cart> carts = cartRepository.findByUser(user);
        if (carts.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        int totalPrice = carts.stream()
                .mapToInt(cart -> cart.getPrice())
                .sum();

        Order order = Order.builder().user(user).price(totalPrice).build();
        order.setStatus("WAIT");
        orderRepository.save(order);


        List<Order_detail> orderDetails = carts.stream()
                .map(cart -> Order_detail.builder()
                        .order(order)
                        .menu(cart.getMenu())
                        .count(cart.getCount())
                        .build())
                .collect(Collectors.toList());

        List<OrderDetailResponseDto> orderDetailResponseDtos = orderDetails.stream()
                .map(OrderDetailResponseDto::new)
                .collect(Collectors.toList());

        myHandler.broadcastOrder(order, orderDetailResponseDtos); //웹소켓 전달

        orderDetailRepository.saveAll(orderDetails);
        cartRepository.deleteAll(carts);

        //orderidx만 반환해도 괜찮을듯
        return order;
    }
    @Transactional
    public OrderResponseDto getOrderById(int order_idx) {
        Order order = orderRepository.findById(order_idx)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));

        List<Order_detail> orderDetails = orderDetailRepository.findByOrder(order);

        List<OrderDetailResponseDto> orderDetailResponseDtos = orderDetails.stream()
                .map(OrderDetailResponseDto::new)
                .collect(Collectors.toList());

        return new OrderResponseDto(order, orderDetailResponseDtos);
    }

    @Transactional
    //최근 주문 내역 (모든 가게 다)
    public List<OrderResponseDto> getOrdersByUserId(int user_idx) {
        Users user = usersRepository.findById(user_idx)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        List<Order> orders = orderRepository.findByUser(user);

        return orders.stream()
                .map(order -> {
                    List<Order_detail> orderDetails = orderDetailRepository.findByOrder(order);
                    List<OrderDetailResponseDto> orderDetailResponseDtos = orderDetails.stream()
                            .map(OrderDetailResponseDto::new)
                            .collect(Collectors.toList());
                    return new OrderResponseDto(order, orderDetailResponseDtos);
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateOrderStatus(int orderIdx, String status) {
        Order order = orderRepository.findById(orderIdx)
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderIdx));
        order.setStatus(status);
    }

}
