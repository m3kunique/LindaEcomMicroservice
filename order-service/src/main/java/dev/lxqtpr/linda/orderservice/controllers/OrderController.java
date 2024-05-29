package dev.lxqtpr.linda.orderservice.controllers;

import dev.lxqtpr.linda.orderservice.dto.order.CreateOrderDto;
import dev.lxqtpr.linda.orderservice.dto.order.ResponseOrderDto;
import dev.lxqtpr.linda.orderservice.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseOrderDto createOrder(@RequestBody @Valid CreateOrderDto createOrderDto){
        return orderService.createOrder(createOrderDto);
    }
    @GetMapping
    public List<ResponseOrderDto> findAllOrders(){
        return orderService.findAllOrders();
    }
    @GetMapping("/{orderId}")
    public ResponseOrderDto findOrderById(@PathVariable Long orderId){
        return orderService.findOrderById(orderId);
    }
}
