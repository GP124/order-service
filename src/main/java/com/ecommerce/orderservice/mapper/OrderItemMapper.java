package com.ecommerce.orderservice.mapper;

import com.ecommerce.orderservice.dto.response.OrderItemResponseDTO;
import com.ecommerce.orderservice.model.OrderItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {
    private final ModelMapper modelMapper;

    public OrderItemMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderItem toEntity(OrderItem dto) {
        return modelMapper.map(dto, OrderItem.class);
    }

    public OrderItemResponseDTO toDTO(OrderItem orderItem) {
        return modelMapper.map(orderItem, OrderItemResponseDTO.class);
    }
}
