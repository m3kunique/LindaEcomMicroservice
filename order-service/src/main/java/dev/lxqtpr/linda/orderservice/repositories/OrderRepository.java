package dev.lxqtpr.linda.orderservice.repositories;

import dev.lxqtpr.linda.orderservice.models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
