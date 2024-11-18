package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import org.springframework.stereotype.Service;


public interface OrderService {

    public OrderItem AddOrder(OrderItemDto order);
}
