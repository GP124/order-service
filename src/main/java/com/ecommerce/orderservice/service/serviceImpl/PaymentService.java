package com.ecommerce.orderservice.service.serviceImpl;

import com.ecommerce.orderservice.dto.request.PaymentRequestDTO;
import com.ecommerce.orderservice.mapper.PaymentMapper;
import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.Payment;
import com.ecommerce.orderservice.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    public Payment processPayment(PaymentRequestDTO dto, OrderEntity orderEntity) {
        Payment payment = paymentMapper.toEntity(dto);
        payment.setOrder(orderEntity);
        payment.setStatus("PENDING");

        return paymentRepository.save(payment);
    }
}
