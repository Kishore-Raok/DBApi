package dev.kishore.dbapi.model;
import dev.kishore.dbapi.dto.CategoryDTO;
import dev.kishore.dbapi.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;
public class CategoryMapper {
    public static CategoryDTO toCategoryDTO(Category category) {
        List<ProductDTO> productDTOs = category.getProducts().stream()
                .map(ProductMapper::toProductDTO)
                .collect(Collectors.toList());

        return new CategoryDTO(
                category.getTitle(),
                productDTOs
        );
    }
}
