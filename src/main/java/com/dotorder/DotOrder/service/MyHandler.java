package com.dotorder.DotOrder.service;

import com.dotorder.DotOrder.domain.Order;
import com.dotorder.DotOrder.domain.Order_detail;
import com.dotorder.DotOrder.dto.OrderDetailResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class MyHandler extends TextWebSocketHandler {

    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 메시지를 처리하고 필요한 경우 연결된 클라이언트에게 메시지를 전송합니다.
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }
    @Autowired
    private ObjectMapper objectMapper;

    public void broadcastOrder(Order order,List<OrderDetailResponseDto> orderDetail) {
        try {
            // Create a map to hold the order and order details
            Map<String, Object> data = new HashMap<>();
            data.put("message", "새 주문");
            data.put("order", order);
            data.put("orderDetails", orderDetail);

            // Convert the map to JSON
            String messageStr = objectMapper.writeValueAsString(data);

            TextMessage message = new TextMessage(messageStr);
            for (WebSocketSession session : sessions) {
                try {
                    session.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
