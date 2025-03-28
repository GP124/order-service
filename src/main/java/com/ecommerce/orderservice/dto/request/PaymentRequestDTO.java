package com.ecommerce.orderservice.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentRequestDTO {
    private String paymentStatus;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
}
