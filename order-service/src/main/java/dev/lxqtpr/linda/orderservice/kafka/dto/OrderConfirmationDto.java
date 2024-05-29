package dev.lxqtpr.linda.orderservice.kafka.dto;

import dev.lxqtpr.linda.orderservice.dto.customers.ResponseCustomerDto;
import dev.lxqtpr.linda.orderservice.dto.products.ResponseProductDto;
import dev.lxqtpr.linda.orderservice.models.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderConfirmationDto {
    private String orderReference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private ResponseCustomerDto customer;
    private List<ResponseProductDto> products;
}
