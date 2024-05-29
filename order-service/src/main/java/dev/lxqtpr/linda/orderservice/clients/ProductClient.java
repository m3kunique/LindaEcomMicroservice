package dev.lxqtpr.linda.orderservice.clients;

import dev.lxqtpr.linda.orderservice.dto.products.CreatePurchaseDto;
import dev.lxqtpr.linda.orderservice.dto.products.ResponseProductDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "products-client",
        url = "${application.config.productUrl}"
)
public interface ProductClient {
    @PostMapping("/purchase")
    List<ResponseProductDto> purchaseProducts(@RequestBody @Valid List<CreatePurchaseDto> createPurchaseDto);
}
