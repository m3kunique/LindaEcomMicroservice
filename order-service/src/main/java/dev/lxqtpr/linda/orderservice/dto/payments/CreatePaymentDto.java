package dev.lxqtpr.linda.orderservice.dto.payments;

import dev.lxqtpr.linda.orderservice.dto.customers.ResponseCustomerDto;
import dev.lxqtpr.linda.orderservice.models.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreatePaymentDto {
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Long orderId;
    private String orderReference;
    private ResponseCustomerDto customerDto;
}

