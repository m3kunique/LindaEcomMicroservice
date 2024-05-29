package dev.lxqtpr.linda.orderservice.kafka.producers;

import dev.lxqtpr.linda.orderservice.kafka.dto.OrderConfirmationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {

    private final KafkaTemplate<String, OrderConfirmationDto> kafkaTemplate;

    public void sendOrderConfirmation(OrderConfirmationDto orderConfirmationDto){
        log.info("Sending order confirmation");
        var message = MessageBuilder
                .withPayload(orderConfirmationDto)
                .setHeader(KafkaHeaders.TOPIC, "order-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
