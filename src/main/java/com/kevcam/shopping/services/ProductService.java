package com.kevcam.shopping.services;

import com.kevcam.shopping.dao.ProductRepository;
import com.kevcam.shopping.entities.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void initializeDatabase() {
        if(productRepository.count() == 0) {
            productRepository.saveAll(
                    List.of(
                            new Product("Laptop", BigDecimal.valueOf(1000)),
                            new Product("Mouse", BigDecimal.valueOf(20)),
                            new Product("Keyboard", BigDecimal.valueOf(50)),
                            new Product("Monitor", BigDecimal.valueOf(200)))
                    ).forEach(System.out::println);
        }
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

}
