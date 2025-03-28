package com.ecommerce.orderservice.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderHistoryRequestDTO {
    private String status;
    private LocalDateTime changedAt;
    private String notes;
}
