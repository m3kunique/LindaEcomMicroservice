package dev.lxqtpr.linda.customerservice.dto;

import dev.lxqtpr.linda.customerservice.models.Address;
import lombok.Data;

@Data
public class ResponseCustomerDto {
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private Address address;
}