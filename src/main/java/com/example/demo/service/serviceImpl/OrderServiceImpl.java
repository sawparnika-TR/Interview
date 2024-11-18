package com.example.demo.service.serviceImpl;

import com.example.demo.dto.OrderItemDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.OrderStatus;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public OrderItem AddOrder(OrderItemDto order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(order.getQuantity());
        orderItem.setProductCode(order.getProductCode());
        orderItem.setUnitPrice(order.getUnitPrice());

        Order order1 = new Order();
        order1.setOrderNumber("111");
        order1.setCreatedAt(LocalDateTime.now());
        order1.setTotalAmount(BigDecimal.valueOf(0.23));
        order1.setStatus(OrderStatus.CREATED);
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        order1.setItems(orderItems);
        orderRepository.save(order1);
        orderItem.setOrder(order1);
        return orderItemRepository.save(orderItem);
    }
}
