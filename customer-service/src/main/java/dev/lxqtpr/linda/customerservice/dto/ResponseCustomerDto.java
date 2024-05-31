package dev.lxqtpr.linda.customerservice.dto;

import dev.lxqtpr.linda.customerservice.models.Address;
import lombok.Data;

@Data
public class ResponseCustomerDto {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Address address;
}