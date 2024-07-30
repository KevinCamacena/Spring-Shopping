package com.kevcam.shopping.controllers;

import com.kevcam.shopping.entities.Product;
import com.kevcam.shopping.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    private final ProductService service;

    public ProductRestController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.findAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getPrroduct(@PathVariable Long id) {
        return ResponseEntity.of(service.findProductById(id));
        //return service.findProductById(id);
    }

}
