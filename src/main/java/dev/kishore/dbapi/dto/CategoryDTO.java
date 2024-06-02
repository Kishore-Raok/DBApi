package dev.kishore.dbapi.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private String title;
    private List<ProductDTO> products;

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "title='" + title + '\'' +
                ", products=" + products +
                '}';
    }
}
