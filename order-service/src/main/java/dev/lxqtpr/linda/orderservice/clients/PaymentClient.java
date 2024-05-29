package dev.lxqtpr.linda.orderservice.clients;

import dev.lxqtpr.linda.orderservice.dto.payments.CreatePaymentDto;
import dev.lxqtpr.linda.orderservice.dto.payments.ResponsePaymentDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-client",
        url = "${application.config.paymentUrl}"
)
public interface PaymentClient {
    @PostMapping("/payments")
    ResponsePaymentDto createPayment(@RequestBody @Valid CreatePaymentDto createPaymentDto);
}
