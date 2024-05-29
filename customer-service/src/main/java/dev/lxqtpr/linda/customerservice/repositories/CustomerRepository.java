package dev.lxqtpr.linda.customerservice.repositories;

import dev.lxqtpr.linda.customerservice.models.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
