package dev.lxqtpr.linda.customerservice.dto;

import dev.lxqtpr.linda.customerservice.models.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCustomerDto{
        @NotBlank(message = "Customer id id required")
        private String id;

        @NotBlank(message = "Customer firstname is required")
        private String firstName;

        @NotBlank(message = "Customer firstname is required")
        private String lastName;

        @NotBlank(message = "Customer Email is required")
        @Email(message = "Customer Email is not a valid email address")
        private String email;

        @Valid
        private Address address;
}