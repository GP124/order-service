package com.ecommerce.orderservice.service.serviceImpl;

import com.ecommerce.orderservice.dto.request.PaymentRequestDTO;
import com.ecommerce.orderservice.mapper.PaymentMapper;
import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.Payment;
import com.ecommerce.orderservice.repositories.PaymentRepository;
import com.ecommerce.orderservice.service.PaymentInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService implements PaymentInterface {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;


    public Payment processPayment(PaymentRequestDTO dto, OrderEntity orderEntity) {
        Payment payment = paymentMapper.toEntity(dto);
        payment.setOrder(orderEntity);
        payment.setStatus("PENDING");

        return paymentRepository.save(payment);
    }
}
