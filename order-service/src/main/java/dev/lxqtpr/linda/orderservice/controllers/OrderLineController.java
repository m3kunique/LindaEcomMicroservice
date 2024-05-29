package dev.lxqtpr.linda.orderservice.controllers;

import dev.lxqtpr.linda.orderservice.dto.order.ResponseOrderDto;
import dev.lxqtpr.linda.orderservice.services.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderLines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/{orderId}")
    public List<ResponseOrderDto> findAllByOrderId(@PathVariable Long orderId){
        return orderLineService.findAllByOrderId(orderId);
    }
}
