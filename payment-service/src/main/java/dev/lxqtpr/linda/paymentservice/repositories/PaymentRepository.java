package dev.lxqtpr.linda.paymentservice.repositories;

import dev.lxqtpr.linda.paymentservice.models.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}