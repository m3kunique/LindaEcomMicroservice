package dev.lxqtpr.linda.productservice.controllers;

import dev.lxqtpr.linda.productservice.dto.products.CreatePurchaseDto;
import dev.lxqtpr.linda.productservice.dto.products.CreateProductDto;
import dev.lxqtpr.linda.productservice.dto.products.ResponseProductDto;
import dev.lxqtpr.linda.productservice.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseProductDto createProduct(@RequestBody @Valid CreateProductDto createProductDto){
        return productService.createProduct(createProductDto);
    }
    @PostMapping("/purchase")
    public List<ResponseProductDto> purchaseProducts(@RequestBody @Valid List<CreatePurchaseDto> createPurchaseDto){
        return productService.purchaseProducts(createPurchaseDto);
    }

    @GetMapping("/{productId}")
    public ResponseProductDto findProductById(@PathVariable Long productId){
        return productService.findProductById(productId);
    }
    @GetMapping()
    public List<ResponseProductDto> findAllProducts(){
        return productService.findAllProducts();
    }
}
