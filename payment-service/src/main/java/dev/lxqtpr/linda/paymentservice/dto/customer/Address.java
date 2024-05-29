package dev.lxqtpr.linda.paymentservice.dto.customer;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
