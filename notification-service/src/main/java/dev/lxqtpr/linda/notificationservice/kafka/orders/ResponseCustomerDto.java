package dev.lxqtpr.linda.notificationservice.kafka.orders;

import lombok.Data;

@Data
public class ResponseCustomerDto {
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private Address address;
}
