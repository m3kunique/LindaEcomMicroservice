package dev.lxqtpr.linda.paymentservice.dto;

import dev.lxqtpr.linda.paymentservice.models.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePaymentDto {
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Long orderId;
    private String orderReference;
    private ResponseCustomerDto customerDto;
}
