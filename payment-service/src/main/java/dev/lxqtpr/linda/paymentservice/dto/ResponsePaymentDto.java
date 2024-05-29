package dev.lxqtpr.linda.paymentservice.dto;

import dev.lxqtpr.linda.paymentservice.models.PaymentMethod;
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
