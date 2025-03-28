package com.ecommerce.orderservice.service.serviceImpl;

import com.ecommerce.orderservice.mapper.OrderItemMapper;
import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.OrderItem;
import com.ecommerce.orderservice.repositories.OrderItemRepository;
import com.ecommerce.orderservice.service.OrderItemServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemService implements OrderItemServiceInterface {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    public OrderItem createOrderItem(OrderItem dto, OrderEntity orderEntity) {
        OrderItem orderItem = orderItemMapper.toEntity(dto);
        orderItem.setOrderItem(orderEntity);
        return orderItemRepository.save(orderItem);
    }
}
