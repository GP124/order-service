package com.ecommerce.orderservice.dto.request;

import com.ecommerce.orderservice.model.OrderItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Data
public class OrderRequestDTO {
    private Long userId;
    private List<OrderItemRequestDTO> items;
    private BigDecimal totalAmount;

    @Getter
    @Setter
    private List<OrderItem> orderItems;

}
