package com.ecommerce.orderservice.mapper;

import com.ecommerce.orderservice.dto.OrderRequestDTO;
import org.hibernate.query.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final ModelMapper modelMapper;

    public OrderMapper(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public Order toEntity(OrderRequestDTO orderRequestDTO){
        return modelMapper.map(orderRequestDTO, Order.class);
    }
}
