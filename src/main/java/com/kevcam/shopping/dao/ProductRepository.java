package com.kevcam.shopping.dao;

import com.kevcam.shopping.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
