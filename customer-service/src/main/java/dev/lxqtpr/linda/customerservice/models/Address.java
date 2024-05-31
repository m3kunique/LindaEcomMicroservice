package dev.lxqtpr.linda.customerservice.models;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Address {

    @NotBlank(message = "Address street is required")
    private String street;

    @NotBlank(message = "Address houseNumber is required")
    private String houseNumber;

    @NotBlank(message = "Address zipCode is required")
    private String zipCode;
}
