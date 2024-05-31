package dev.lxqtpr.linda.orderservice.dto.customers;

import lombok.Data;

@Data
public class ResponseCustomerDto {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Address address;
}