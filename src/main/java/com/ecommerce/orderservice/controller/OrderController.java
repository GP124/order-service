package com.ecommerce.orderservice.controller;

import com.ecommerce.orderservice.dto.request.OrderRequestDTO;
import com.ecommerce.orderservice.dto.response.OrderResponseDTO;
import com.ecommerce.orderservice.enums.OrderEvent;
import com.ecommerce.orderservice.service.serviceImpl.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create a new order
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO orderResponse = orderService.createOrder(orderRequestDTO);
        return ResponseEntity.ok(orderResponse);
    }

    // Get order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long orderId) {
        OrderResponseDTO orderResponse = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderResponse);
    }

    // Process order state transition
    @PostMapping("/{orderId}/process/{event}")
    public ResponseEntity<OrderResponseDTO> processOrder(@PathVariable Long orderId, @PathVariable String event) {
        try {
            OrderEvent orderEvent = OrderEvent.valueOf(event.toUpperCase());
            OrderResponseDTO orderResponse = orderService.processOrder(orderId, orderEvent);
            return ResponseEntity.ok(orderResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
