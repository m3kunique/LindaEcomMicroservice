package dev.lxqtpr.linda.productservice.repositories;

import dev.lxqtpr.linda.productservice.models.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
