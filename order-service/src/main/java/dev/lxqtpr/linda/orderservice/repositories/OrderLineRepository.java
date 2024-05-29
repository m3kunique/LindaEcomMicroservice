package dev.lxqtpr.linda.orderservice.repositories;

import dev.lxqtpr.linda.orderservice.models.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Long> {
    List<OrderLineEntity> findAllByOrderId(Long orderId);
}
