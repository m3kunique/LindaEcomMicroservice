package dev.lxqtpr.linda.orderservice.dto.orderline;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateOrderLineDto {
    @NotNull(message = "Product is mandatory")
    private Long productId;
    @Positive(message = "Quantity is mandatory")
    private Double quantity;
}
