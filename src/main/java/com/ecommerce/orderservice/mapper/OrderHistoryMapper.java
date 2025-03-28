package com.ecommerce.orderservice.mapper;

import com.ecommerce.orderservice.dto.response.OrderHistoryResponseDTO;
import com.ecommerce.orderservice.model.OrderHistory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderHistoryMapper {
    private final ModelMapper modelMapper;

    public OrderHistoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderHistoryResponseDTO toDTO(OrderHistory orderHistory) {
        return modelMapper.map(orderHistory, OrderHistoryResponseDTO.class);
    }
}
