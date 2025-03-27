package com.ecommerce.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private Long orderId;

private Long userId;
private BigDecimal totalAmount;
private String status;

@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
private List<OrderItem> orderItems;

@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
private Payment payment;

@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
private List<OrderHistory> orderHistories;
}
