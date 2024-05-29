package dev.lxqtpr.linda.orderservice.dto.orderline;

import lombok.Data;

@Data
public class ResponseOrderLineEntity {
    private Long id;
    private Long productId;
    private Double quantity;
}
