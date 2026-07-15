package com.aeropelican.productservice.controller;

import com.aeropelican.productservice.entity.Product;
import com.aeropelican.productservice.repository.ProductRepository;
import com.aeropelican.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> result = productService.listProducts();
        return result;
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/{productId}/{quantity}")
    public Product updateProduct(@PathVariable("productId") Integer id, @PathVariable("quantity") Integer qty) {
        return productService.updateProduct(id, qty);
    }
}
