package com.ecommerce.orderservice.service.serviceImpl;

import com.ecommerce.orderservice.mapper.OrderItemMapper;
import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.OrderItem;
import com.ecommerce.orderservice.repositories.OrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderItemService(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    public OrderItem createOrderItem(OrderItem dto, OrderEntity orderEntity) {
        OrderItem orderItem = orderItemMapper.toEntity(dto);
        orderItem.setOrderItem(orderEntity);
        return orderItemRepository.save(orderItem);
    }
}
