package dev.kishore.dbapi.repositories;

import dev.kishore.dbapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
