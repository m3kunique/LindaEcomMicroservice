package dev.lxqtpr.linda.notificationservice.kafka.orders;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResponseProductDto {
    private Long id;
    private String name;
    private String description;
    private Double availableQuantity;
    private BigDecimal price;
    private ResponseCategoryDto category;
}
