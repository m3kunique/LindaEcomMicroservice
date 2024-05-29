package dev.lxqtpr.linda.customerservice.dto;

import dev.lxqtpr.linda.customerservice.models.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCustomerDto {
    @NotNull(message = "Customer firstname is required")
    private String firstname;

    @NotNull(message = "Customer firstname is required")
    private String lastname;

    @NotNull(message = "Customer Email is required")
    @Email(message = "Customer Email is not a valid email address")
    private String email;

    private Address address;
}
