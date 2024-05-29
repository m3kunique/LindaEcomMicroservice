package dev.lxqtpr.linda.productservice.repositories;

import dev.lxqtpr.linda.productservice.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByIdInOrderById(List<Long> productIds);
}
