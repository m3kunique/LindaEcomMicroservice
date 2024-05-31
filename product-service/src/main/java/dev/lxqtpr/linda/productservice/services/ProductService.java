package dev.lxqtpr.linda.productservice.services;

import dev.lxqtpr.linda.productservice.dto.products.CreateProductDto;
import dev.lxqtpr.linda.productservice.dto.products.CreatePurchaseDto;
import dev.lxqtpr.linda.productservice.dto.products.ResponseProductDto;
import dev.lxqtpr.linda.productservice.exceptions.ProductPurchaseException;
import dev.lxqtpr.linda.productservice.exceptions.ResourceNotFoundException;
import dev.lxqtpr.linda.productservice.models.ProductEntity;
import dev.lxqtpr.linda.productservice.repositories.CategoryRepository;
import dev.lxqtpr.linda.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ResponseProductDto createProduct(CreateProductDto createProductDto) {
        var category = categoryRepository.findById(createProductDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category with this id does not exist"));
        var productToSave = modelMapper.map(createProductDto, ProductEntity.class);
        productToSave.setCategory(category);
        return modelMapper
                .map(productRepository.save(productToSave), ResponseProductDto.class);
    }

    public List<ResponseProductDto> purchaseProducts(List<CreatePurchaseDto> createPurchaseDto) {
        var productIds = createPurchaseDto
                .stream()
                .map(CreatePurchaseDto::getProductId)
                .toList();
        var products = productRepository.findAllByIdInOrderById(productIds);
        var purchasedProducts = new ArrayList<ResponseProductDto>();
        if (products.size() != createPurchaseDto.size()){
            throw new ProductPurchaseException("One or more products does not exist");
        }
        var productsToPurchase = createPurchaseDto
                .stream()
                .sorted(Comparator.comparing(CreatePurchaseDto::getProductId))
                .toList();
        for (int i = 0; i < products.size(); i++ ){
            var product = products.get(i);
            var productToPurchase = productsToPurchase.get(i);
            if (Boolean.FALSE.equals(isProductAvailableToPurchase(product,productToPurchase))){
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID" + productToPurchase.getProductId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productToPurchase.getQuantity();
            product.setAvailableQuantity(newAvailableQuantity);
            purchasedProducts.add(modelMapper.map(productRepository.save(product), ResponseProductDto.class));
        }
        return purchasedProducts;
    }

    public ResponseProductDto findProductById(Long productId) {
        var product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with this id does not exist"));
        return modelMapper.map(product, ResponseProductDto.class);
    }

    public List<ResponseProductDto> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(el -> modelMapper.map(el, ResponseProductDto.class))
                .toList();
    }
    private Boolean isProductAvailableToPurchase(ProductEntity product, CreatePurchaseDto createPurchaseDto){
        return Objects.equals(product.getId(), createPurchaseDto.getProductId()) &&
                product.getAvailableQuantity() >= createPurchaseDto.getQuantity();
    }
}
