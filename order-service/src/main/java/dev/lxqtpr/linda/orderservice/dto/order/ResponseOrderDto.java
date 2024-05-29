package dev.lxqtpr.linda.orderservice.dto.order;

import dev.lxqtpr.linda.orderservice.dto.orderline.ResponseOrderLineEntity;
import dev.lxqtpr.linda.orderservice.models.PaymentMethod;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResponseOrderDto {
    private Long id;

    private String reference;

    private BigDecimal totalAmount;

    private PaymentMethod paymentMethod;

    private String customerId;

    private List<ResponseOrderLineEntity> orderLines;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;
}
