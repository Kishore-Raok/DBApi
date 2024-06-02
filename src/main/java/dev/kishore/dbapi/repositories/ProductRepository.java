package dev.kishore.dbapi.repositories;

import dev.kishore.dbapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
