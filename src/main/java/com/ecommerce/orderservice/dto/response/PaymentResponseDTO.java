package com.ecommerce.orderservice.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentResponseDTO {
    private Long paymentId;
    private String paymentMethod;
    private BigDecimal amount;
    private String status;
}
