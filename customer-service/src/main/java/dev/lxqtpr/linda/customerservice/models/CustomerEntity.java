package dev.lxqtpr.linda.customerservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class CustomerEntity {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
