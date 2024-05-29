package dev.lxqtpr.linda.productservice.dto.categories;

import lombok.Data;

@Data
public class UpdateCategoryDto {
    private Long id;
    private String name;
    private String description;
}
