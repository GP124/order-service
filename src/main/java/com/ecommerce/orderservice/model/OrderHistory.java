package com.ecommerce.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity orderEntity;

    private String status;
    private LocalDateTime changedAt;
    private String notes;

    public void setOrderItem(OrderEntity orderEntity) {
    }

    public void setUpdatedAt(LocalDateTime now) {

    }
}
