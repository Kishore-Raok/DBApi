package dev.kishore.dbapi.service;

import dev.kishore.dbapi.dto.ProductDTO;
import dev.kishore.dbapi.model.Category;
import dev.kishore.dbapi.model.Product;
import dev.kishore.dbapi.model.ProductMapper;
import dev.kishore.dbapi.repositories.CategoryRepository;
import dev.kishore.dbapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::toProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Category category;

        if (productDTO.getCategoryId() != null) {
            category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
        } else {
            category = new Category();
            category.setTitle("Default Category"); // Set default category title or any other logic
            categoryRepository.save(category);
        }

        Product product = new Product(
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getImageUrl(),
                productDTO.getWeight(),
                category
        );
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setTitle(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);

        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
