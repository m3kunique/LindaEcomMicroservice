package dev.lxqtpr.linda.paymentservice.dto.customer;

import lombok.Data;

@Data
public class ResponseCustomerDto {
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private Address address;
}
