package dev.lxqtpr.linda.productservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionBody {
    private String message;
    private Integer status;
}