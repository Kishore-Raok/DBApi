package dev.kishore.dbapi.service;

import dev.kishore.dbapi.dto.ProductDTO;
import org.springframework.data.domain.Page;



public interface ProductService {
    Page<ProductDTO> getAllProducts(int pageNumber, int pageSize);
    ProductDTO getProductById(Long id);
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}
