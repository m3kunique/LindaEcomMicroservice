package dev.lxqtpr.linda.productservice.dto.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductDto {

    @NotNull(message = "Product name is required")
    private String name;
    @NotNull(message = "Product description is required")
    private String description;
    @Positive(message = "Available quantity should be positive")
    private Double availableQuantity;
    @Positive(message = "Price should be positive")
    private BigDecimal price;
    @NotNull(message = "Product category is required")
    private Long categoryId;
}
