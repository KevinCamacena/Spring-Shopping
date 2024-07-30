package com.kevcam.shopping.dao;

import com.kevcam.shopping.entities.Product;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThanEqual(@PositiveOrZero(message = "Price must be positive or zero") BigDecimal price);
    List<Product> findTop10ByNameContainsOrderByPrice(String regex);
}
