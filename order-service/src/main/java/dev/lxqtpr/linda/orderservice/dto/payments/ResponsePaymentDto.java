package dev.lxqtpr.linda.orderservice.dto.payments;

import dev.lxqtpr.linda.orderservice.models.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ResponsePaymentDto {
    private Long id;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

    private Long orderId;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;
}
