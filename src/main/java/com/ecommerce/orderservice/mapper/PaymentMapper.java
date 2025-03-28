package com.ecommerce.orderservice.mapper;

import com.ecommerce.orderservice.dto.request.PaymentRequestDTO;
import com.ecommerce.orderservice.dto.response.PaymentResponseDTO;
import com.ecommerce.orderservice.model.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    private final ModelMapper modelMapper;

    public PaymentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Payment toEntity(PaymentRequestDTO dto) {
        return modelMapper.map(dto, Payment.class);
    }

    public PaymentResponseDTO toDTO(Payment payment) {
        return modelMapper.map(payment, PaymentResponseDTO.class);
    }
}
