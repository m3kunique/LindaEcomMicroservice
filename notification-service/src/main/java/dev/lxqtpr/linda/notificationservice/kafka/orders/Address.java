package dev.lxqtpr.linda.notificationservice.kafka.orders;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}