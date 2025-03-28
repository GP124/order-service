package com.ecommerce.orderservice.service.serviceImpl;

import com.ecommerce.orderservice.dto.request.OrderRequestDTO;
import com.ecommerce.orderservice.dto.response.OrderResponseDTO;
import com.ecommerce.orderservice.enums.OrderEvent;
import com.ecommerce.orderservice.enums.OrderState;
import com.ecommerce.orderservice.exception.OrderNotFoundException;
import com.ecommerce.orderservice.mapper.OrderMapper;
import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.OrderItem;
import com.ecommerce.orderservice.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final StateMachine<OrderState, OrderEvent> stateMachine;
    private final OrderMapper orderMapper;
    private final OrderItemService orderItemService;
    private final PaymentService paymentService;
    private final OrderHistoryService orderHistoryService;



    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        OrderEntity orderEntity = orderMapper.toEntity(orderRequestDTO);
        orderEntity.setStatus(OrderState.NEW);

        orderEntity = orderRepository.save(orderEntity);

        final OrderEntity savedOrderEntity = orderRepository.save(orderEntity);

        List<OrderItem> orderItems = Optional.ofNullable(orderRequestDTO.getOrderItems())
                .orElse(Collections.emptyList())
                .stream()
                .map(itemDTO -> orderItemService.createOrderItem(itemDTO, savedOrderEntity))
                .collect(Collectors.toList());
        orderEntity.setOrderItems(orderItems);

        orderRepository.save(orderEntity);
        orderHistoryService.addHistory(orderEntity, "Order Created");

        return orderMapper.toDTO(orderEntity);
    }

    // Process order state transitions
    public OrderResponseDTO processOrder(Long orderId, OrderEvent event) {
        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        Message<OrderEvent> message = MessageBuilder.withPayload(event)
                .setHeader("orderId", orderId)
                .build();

        stateMachine.sendEvent(message);

        orderEntity.setStatus(stateMachine.getState().getId()); // Update the state
        orderRepository.save(orderEntity);
        orderHistoryService.addHistory(orderEntity, "Order moved to " + orderEntity.getStatus());

        return orderMapper.toDTO(orderEntity);
    }

    public OrderResponseDTO getOrderById(Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
        return orderMapper.toDTO(orderEntity);
    }
}
