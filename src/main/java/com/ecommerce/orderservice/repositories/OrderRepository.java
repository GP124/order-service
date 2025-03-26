package com.ecommerce.orderservice.repositories;
import com.ecommerce.orderservice.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
        Optional<OrderEntity> findById(Long orderId);

}
