package com.ecommerce.orderservice.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDTO {
private Long orderId;
private Long userId;
private List<OrderItemResponseDTO> orderItems;
private PaymentResponseDTO payment;
private List<OrderHistoryResponseDTO> orderHistory;
private String status;
private LocalDateTime createdAt;
}