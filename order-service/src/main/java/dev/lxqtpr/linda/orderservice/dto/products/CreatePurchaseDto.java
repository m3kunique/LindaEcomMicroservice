package dev.lxqtpr.linda.orderservice.dto.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreatePurchaseDto {
    @NotNull(message = "Product is mandatory")
    private Long productId;
    @Positive(message = "Quantity is mandatory")
    private Double quantity;
}

