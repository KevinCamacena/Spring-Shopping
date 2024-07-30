package com.kevcam.shopping.entities;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Integer id) {
        super("Product NOT FOUND with id "  + id);
    }
}
