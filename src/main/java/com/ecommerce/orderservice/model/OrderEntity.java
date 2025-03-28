package com.ecommerce.orderservice.model;

import com.ecommerce.orderservice.enums.OrderState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Enumerated(EnumType.STRING)
    private OrderState status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderHistory> orderHistories;


}
