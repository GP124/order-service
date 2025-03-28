package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.dto.request.OrderRequestDTO;
import com.ecommerce.orderservice.dto.response.OrderResponseDTO;
import com.ecommerce.orderservice.enums.OrderEvent;

public interface OrderServiceInterface {
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO processOrder(Long orderId, OrderEvent event);

    OrderResponseDTO getOrderById(Long orderId);
}
