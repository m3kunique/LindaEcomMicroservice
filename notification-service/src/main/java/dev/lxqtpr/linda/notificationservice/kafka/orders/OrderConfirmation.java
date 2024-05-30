package dev.lxqtpr.linda.notificationservice.kafka.orders;

import dev.lxqtpr.linda.notificationservice.kafka.payments.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderConfirmation {
    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private ResponseCustomerDto customer;
    private List<ResponseProductDto> products;
}
