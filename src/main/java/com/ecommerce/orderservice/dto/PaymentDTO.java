package com.ecommerce.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentDTO {
    private String paymentStatus;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
}
