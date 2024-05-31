package dev.lxqtpr.linda.customerservice.controllers;

import dev.lxqtpr.linda.customerservice.dto.CreateCustomerDto;
import dev.lxqtpr.linda.customerservice.dto.ResponseCustomerDto;
import dev.lxqtpr.linda.customerservice.dto.UpdateCustomerDto;
import dev.lxqtpr.linda.customerservice.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<ResponseCustomerDto> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{customerId}")
    public ResponseCustomerDto findAllCustomers(@PathVariable String customerId) {
        return customerService.findCustomerById(customerId);
    }

    @PostMapping
    public ResponseCustomerDto createCustomer(@RequestBody @Valid CreateCustomerDto createCustomerDto) {
        return customerService.createCustomer(createCustomerDto);
    }

    @PutMapping
    public ResponseCustomerDto updateCustomer(@RequestBody @Valid UpdateCustomerDto updateCustomerDto) {
        return customerService.updateCustomer(updateCustomerDto);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }
}
