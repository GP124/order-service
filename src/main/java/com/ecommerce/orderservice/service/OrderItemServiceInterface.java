package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.OrderItem;

public interface OrderItemServiceInterface {
    OrderItem createOrderItem(OrderItem dto, OrderEntity orderEntity);
}
