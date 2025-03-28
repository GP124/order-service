package com.ecommerce.orderservice.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderItemResponseDTO {
    private Long orderItemId;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
