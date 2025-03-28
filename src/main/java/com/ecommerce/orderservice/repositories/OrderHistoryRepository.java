package com.ecommerce.orderservice.repositories;

import com.ecommerce.orderservice.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
    List<OrderHistory> findByOrderId(Long orderId);
}
