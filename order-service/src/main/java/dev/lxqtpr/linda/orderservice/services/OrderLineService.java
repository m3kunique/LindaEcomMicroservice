package dev.lxqtpr.linda.orderservice.services;

import dev.lxqtpr.linda.orderservice.dto.order.ResponseOrderDto;
import dev.lxqtpr.linda.orderservice.repositories.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository orderLineRepository;
    private final ModelMapper modelMapper;

    public List<ResponseOrderDto> findAllByOrderId(Long orderId) {
        return orderLineRepository
                .findAllByOrderId(orderId)
                .stream()
                .map(el -> modelMapper.map(el, ResponseOrderDto.class))
                .toList();
    }
}
