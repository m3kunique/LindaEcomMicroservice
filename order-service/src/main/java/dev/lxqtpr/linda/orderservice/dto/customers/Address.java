package dev.lxqtpr.linda.orderservice.dto.customers;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}