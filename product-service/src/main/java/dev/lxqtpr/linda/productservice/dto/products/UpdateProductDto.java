package dev.lxqtpr.linda.productservice.dto.products;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductDto {
    private Long id;
    private String name;
    private String description;
    private Double availableQuantity;
    private BigDecimal price;
}
