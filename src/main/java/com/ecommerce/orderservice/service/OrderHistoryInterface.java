package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.OrderHistory;

import java.util.List;

public interface OrderHistoryInterface {
    List<OrderHistory> getOrderHistory(Long orderId);
}
