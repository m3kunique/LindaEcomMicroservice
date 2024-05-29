package dev.lxqtpr.linda.paymentservice.controllers;

import dev.lxqtpr.linda.paymentservice.dto.CreatePaymentDto;
import dev.lxqtpr.linda.paymentservice.dto.ResponsePaymentDto;
import dev.lxqtpr.linda.paymentservice.services.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponsePaymentDto createPayment(@RequestBody @Valid CreatePaymentDto createPaymentDto){
        return paymentService.createPayment(createPaymentDto);
    }
}
