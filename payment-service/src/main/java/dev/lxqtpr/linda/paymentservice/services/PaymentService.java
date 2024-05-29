package dev.lxqtpr.linda.paymentservice.services;

import dev.lxqtpr.linda.paymentservice.dto.CreatePaymentDto;
import dev.lxqtpr.linda.paymentservice.dto.PaymentNotificationDto;
import dev.lxqtpr.linda.paymentservice.dto.ResponsePaymentDto;
import dev.lxqtpr.linda.paymentservice.kafka.notification.NotificationProducer;
import dev.lxqtpr.linda.paymentservice.models.PaymentEntity;
import dev.lxqtpr.linda.paymentservice.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;
    private final ModelMapper modelMapper;


    public ResponsePaymentDto createPayment(CreatePaymentDto createPaymentDto) {
        var paymentToSave = modelMapper.map(createPaymentDto, PaymentEntity.class);
        var customer = createPaymentDto.getCustomerDto();
        notificationProducer.sendNotification(
                PaymentNotificationDto.builder()
                        .orderReference(createPaymentDto.getOrderReference())
                        .paymentMethod(createPaymentDto.getPaymentMethod())
                        .customerEmail(customer.getEmail())
                        .customerFirstName(customer.getFirstname())
                        .customerLastName(customer.getLastname())
                        .amount(createPaymentDto.getAmount())
                        .build()
        );

        return modelMapper.map(paymentRepository.save(paymentToSave), ResponsePaymentDto.class);
    }
}
