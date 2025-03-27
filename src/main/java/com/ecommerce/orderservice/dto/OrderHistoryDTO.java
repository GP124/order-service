package com.ecommerce.orderservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderHistoryDTO {
    private String status;
    private LocalDateTime changedAt;
    private String notes;
}
