package com.ecommerce.orderservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.Order;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private String status;
    private LocalDateTime changedAt;
    private String notes;

}
