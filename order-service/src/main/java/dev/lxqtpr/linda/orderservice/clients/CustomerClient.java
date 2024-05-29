package dev.lxqtpr.linda.orderservice.clients;

import dev.lxqtpr.linda.orderservice.dto.customers.ResponseCustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customerUrl}"
)
public interface CustomerClient {

    @GetMapping("/{customerId}")
    ResponseCustomerDto findCustomerById(@PathVariable String customerId);
}
