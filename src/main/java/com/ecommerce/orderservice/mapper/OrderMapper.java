package com.ecommerce.orderservice.mapper;

import com.ecommerce.orderservice.dto.request.OrderRequestDTO;
import com.ecommerce.orderservice.dto.response.OrderResponseDTO;
import com.ecommerce.orderservice.model.OrderEntity;
import org.hibernate.query.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final ModelMapper modelMapper;

    public OrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderEntity toEntity(OrderRequestDTO orderRequestDTO) {
        return modelMapper.map(orderRequestDTO, OrderEntity.class);
    }

    public OrderResponseDTO toDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderResponseDTO.class);
    }
}
