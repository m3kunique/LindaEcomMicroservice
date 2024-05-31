package dev.lxqtpr.linda.orderservice.dto.order;

import dev.lxqtpr.linda.orderservice.dto.orderline.CreateOrderLineDto;
import dev.lxqtpr.linda.orderservice.dto.orderline.ResponseOrderLineEntity;
import dev.lxqtpr.linda.orderservice.dto.products.CreatePurchaseDto;
import dev.lxqtpr.linda.orderservice.models.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderDto {
    @NotBlank(message = "Order reference be present")
    private String reference;

    @Positive(message = "Order amount should be positive")
    private BigDecimal totalAmount;

    @NotNull(message = "Payment method should be precised")
    private PaymentMethod paymentMethod;

    @NotBlank(message = "Customer should be present")
    private String customerId;

    @NotEmpty(message = "You should at least purchase one product")
    private List<CreatePurchaseDto> purchaseProducts;
}
