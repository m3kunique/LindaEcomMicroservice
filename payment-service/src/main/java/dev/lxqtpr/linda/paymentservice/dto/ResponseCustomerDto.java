package dev.lxqtpr.linda.paymentservice.dto;

import dev.lxqtpr.linda.paymentservice.dto.customer.Address;
import lombok.Data;

@Data
public class ResponseCustomerDto {
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private Address address;
}
