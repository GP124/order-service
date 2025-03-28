package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.dto.request.PaymentRequestDTO;
import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.Payment;

public interface PaymentInterface {
    Payment processPayment(PaymentRequestDTO dto, OrderEntity orderEntity);
}
