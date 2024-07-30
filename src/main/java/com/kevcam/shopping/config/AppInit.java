package com.kevcam.shopping.config;

import com.kevcam.shopping.dao.ProductRepository;
import com.kevcam.shopping.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class AppInit implements CommandLineRunner {
    private final ProductRepository productRepository;


    public AppInit(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count() == 0) {
            productRepository.saveAll(
                    List.of(
                            new Product("Laptop", BigDecimal.valueOf(1000)),
                            new Product("Mouse", BigDecimal.valueOf(20)),
                            new Product("Keyboard", BigDecimal.valueOf(50)),
                            new Product("Monitor", BigDecimal.valueOf(200)))
                            //new Product(" ", BigDecimal.valueOf(-1.0)))
                    ).forEach(System.out::println);
        }
    }
}
