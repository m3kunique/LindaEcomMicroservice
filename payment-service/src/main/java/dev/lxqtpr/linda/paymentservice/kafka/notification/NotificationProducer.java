package dev.lxqtpr.linda.paymentservice.kafka.notification;

import dev.lxqtpr.linda.paymentservice.dto.PaymentNotificationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final KafkaTemplate<String, PaymentNotificationDto> kafkaTemplate;

    public void sendNotification(PaymentNotificationDto paymentNotification){
        log.info("Sending notification with body <{}>", paymentNotification);
        var message = MessageBuilder
                .withPayload(paymentNotification)
                .setHeader(KafkaHeaders.TOPIC, "payment-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
