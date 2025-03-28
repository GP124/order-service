package com.ecommerce.orderservice.service.serviceImpl;

import com.ecommerce.orderservice.model.OrderEntity;
import com.ecommerce.orderservice.model.OrderHistory;
import com.ecommerce.orderservice.repositories.OrderHistoryRepository;
import com.ecommerce.orderservice.service.OrderHistoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderHistoryService implements OrderHistoryInterface {
    private final OrderHistoryRepository orderHistoryRepository;


    public void addHistory(OrderEntity orderEntity, String status) {
        OrderHistory history = new OrderHistory();
        history.setOrderItem(orderEntity);
        history.setStatus(status);
        history.setUpdatedAt(LocalDateTime.now());

        orderHistoryRepository.save(history);
    }

    public List<OrderHistory> getOrderHistory(Long orderId) {
        return orderHistoryRepository.findByOrderId(orderId);
    }
}
