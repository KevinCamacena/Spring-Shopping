package com.kevcam.shopping.controllers;

import com.kevcam.shopping.entities.Product;
import com.kevcam.shopping.services.ProductService;
import jakarta.servlet.ServletException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import static org.springframework.web.servlet.function.ServerResponse.ok;
@Component
public class ProductHandler {
    private final ProductService service;

    public ProductHandler(ProductService service) {
        this.service = service;
    }

    public ServerResponse getAllProducts(ServerRequest request) {
        return ok().body(service.findAll());
    }

    public ServerResponse getProductById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        Optional<Product> optional = service.findById(id);
        return optional.map(product ->
                        ok().contentType(MediaType.APPLICATION_JSON).body(product))
                .orElseGet(() -> ServerResponse.notFound().build());
    }

    public ServerResponse createProduct(ServerRequest request) throws ServletException, IOException {
        Product product = service.saveProduct(request.body(Product.class));
        URI uri = ServletUriComponentsBuilder.fromServletMapping(request.servletRequest())
                .path(product.getId().toString()).build()
                .toUri();
        return ServerResponse.created(uri).body(product);
    }
}
