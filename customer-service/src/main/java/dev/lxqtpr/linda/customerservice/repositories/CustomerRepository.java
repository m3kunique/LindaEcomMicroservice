package dev.lxqtpr.linda.customerservice.repositories;

import dev.lxqtpr.linda.customerservice.models.CustomerEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

    Optional<CustomerEntity> findByEmail(String email);
}
