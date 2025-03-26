package com.ecommerce.orderservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.Order;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
