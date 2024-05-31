package dev.lxqtpr.linda.notificationservice.kafka.orders;

import lombok.Data;

@Data
public class ResponseCustomerDto {
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Address address;
}
