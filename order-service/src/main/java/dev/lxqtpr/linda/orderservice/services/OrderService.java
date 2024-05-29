package dev.lxqtpr.linda.orderservice.services;

import dev.lxqtpr.linda.orderservice.exceptions.ResourceNotFoundException;
import dev.lxqtpr.linda.orderservice.kafka.dto.OrderConfirmationDto;
import dev.lxqtpr.linda.orderservice.kafka.producers.OrderProducer;
import dev.lxqtpr.linda.orderservice.models.OrderEntity;
import dev.lxqtpr.linda.orderservice.models.OrderLineEntity;
import dev.lxqtpr.linda.orderservice.repositories.OrderLineRepository;
import dev.lxqtpr.linda.orderservice.repositories.OrderRepository;
import dev.lxqtpr.linda.orderservice.clients.CustomerClient;
import dev.lxqtpr.linda.orderservice.clients.ProductClient;
import dev.lxqtpr.linda.orderservice.dto.order.CreateOrderDto;
import dev.lxqtpr.linda.orderservice.dto.order.ResponseOrderDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final OrderLineRepository orderLineRepository;
    private final OrderProducer orderProducer;

    public ResponseOrderDto createOrder(CreateOrderDto createOrderDto) {
        var customer = customerClient.findCustomerById(createOrderDto.getCustomerId());
        var purchasedProducts = productClient.purchaseProducts(createOrderDto.getPurchaseProducts());
        var orderToSave = modelMapper.map(createOrderDto, OrderEntity.class);

        createOrderDto.getPurchaseProducts()
                .forEach(product -> {
                    var orderLineToSave = modelMapper.map(product, OrderLineEntity.class);
                    orderLineToSave.setOrder(orderToSave);
                    orderLineRepository.save(orderLineToSave);
                });

        var messageToKafka = OrderConfirmationDto.builder()
                .orderReference(createOrderDto.getReference())
                .customer(customer)
                .paymentMethod(createOrderDto.getPaymentMethod())
                .products(purchasedProducts)
                .totalAmount(createOrderDto.getTotalAmount())
                .build();
        orderProducer.sendOrderConfirmation(messageToKafka);

        return modelMapper.map(orderRepository.save(orderToSave), ResponseOrderDto.class);
    }

    public List<ResponseOrderDto> findAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(el -> modelMapper.map(el, ResponseOrderDto.class))
                .toList();
    }

    public ResponseOrderDto findOrderById(Long orderId) {
        var order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order with this id does not exist"));
        return modelMapper.map(order, ResponseOrderDto.class);
    }
}
