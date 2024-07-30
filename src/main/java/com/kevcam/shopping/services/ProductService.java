package com.kevcam.shopping.services;

import com.kevcam.shopping.dao.ProductRepository;
import com.kevcam.shopping.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void initializeDatabase() {
        if (repository.count() == 0) {
            repository.saveAll(Arrays.asList(
                    new Product("baseball", 5.0),
                    new Product("football", 12.0),
                    new Product("basketball", 10.0)
            ));
        }
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> findAllByMinimumPrice(Double minPrice) {
        return repository.findAllByPriceGreaterThanEqual(BigDecimal.valueOf(minPrice));
    }

    public Optional<Product> findById(Integer id) {
        return repository.findById(Long.valueOf(id));
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(Integer id) {
        repository.deleteById(Long.valueOf(id));
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

}
