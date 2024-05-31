package dev.lxqtpr.linda.paymentservice.dto;

import dev.lxqtpr.linda.paymentservice.dto.customer.Address;
import lombok.Data;

@Data
public class ResponseCustomerDto {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Address address;
}
