package dev.lxqtpr.linda.notificationservice.kafka;

import dev.lxqtpr.linda.notificationservice.models.NotificationEntity;
import dev.lxqtpr.linda.notificationservice.models.NotificationType;
import dev.lxqtpr.linda.notificationservice.kafka.orders.OrderConfirmation;
import dev.lxqtpr.linda.notificationservice.models.PaymentConfirmation;
import dev.lxqtpr.linda.notificationservice.repositories.NotificationRepository;
import dev.lxqtpr.linda.notificationservice.services.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository notificationRepository;
    private final EmailService emailService;


    @KafkaListener(topics = "payment-topic")
    public void consumePaymentConfirmationNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Consuming message from payment-topic");
        notificationRepository.save(
                NotificationEntity.builder()
                        .notificationType(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        var customerFullName = paymentConfirmation.getCustomerFirstName() + "" + paymentConfirmation.getCustomerLastName();
        emailService.sendPaymentEmail(
                paymentConfirmation.getCustomerEmail(),
                customerFullName,
                paymentConfirmation.getAmount(),
                paymentConfirmation.getOrderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Consuming message from order-topic");
        notificationRepository.save(
                NotificationEntity.builder()
                        .notificationType(NotificationType.ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        var customer = orderConfirmation.getCustomer();
        var customerFullName = customer.getFirstName() + "" + customer.getLastName();
        emailService.sendOrderConfirmationEmail(
                customer.getEmail(),
                customerFullName,
                orderConfirmation.getTotalAmount(),
                orderConfirmation.getOrderReference(),
                orderConfirmation.getProducts()
        );
    }

}
