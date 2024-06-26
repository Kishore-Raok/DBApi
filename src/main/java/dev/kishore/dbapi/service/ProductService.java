package dev.kishore.dbapi.service;

import dev.kishore.dbapi.dto.ProductDTO;
import dev.kishore.dbapi.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    List<ProductDTO> getAllProducts();
    Page<Product> getProducts(int page, int size, String sortField, String sortDirection);
    List<ProductDTO> getAllProducts(Optional<Integer> page, Optional<Integer> size, Optional<String> sortField, Optional<String> sortDirection);
    ProductDTO getProductById(Long id);
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}
