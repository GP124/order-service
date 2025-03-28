package com.ecommerce.orderservice.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderHistoryResponseDTO {
    private Long historyId;
    private String status;
    private String comments;
    private LocalDateTime updatedAt;
}
