package com.kevcam.shopping.config;

import com.kevcam.shopping.controllers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class FunctionalBeans {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(ProductHandler handler) {
        return route().path("/function",
                builder -> builder
                        .GET("", handler::getAllProducts)
                        .GET("{id}", handler::getProductById)
                        .POST("", handler::createProduct)
                ).build();
    }
}
