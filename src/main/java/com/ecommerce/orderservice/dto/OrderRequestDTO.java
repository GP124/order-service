package com.ecommerce.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO {
    private Long userId;
    private List<OrderItemDTO> items;
    private BigDecimal totalAmount;
}
