package com.ecommerce.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity orderEntity;

    private Long productId;
    private Integer quantity;
    private BigDecimal price;

    public void setOrderItem(OrderEntity orderEntity) {
    }
}
