package com.aeropelican.productservice.service;

import com.aeropelican.productservice.entity.Product;
import com.aeropelican.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeMBeanException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listProducts() {
        List<Product> results = productRepository.findAll();
        return results;
    }

    public Product getProduct(Integer productId) {
        return productRepository.findById(productId).get();
    }

    public Product updateProduct(Integer productId, Integer quantity) {
        Product product = productRepository.findById(productId).get();
        product.setQuantity(quantity);
        productRepository.save(product);
        return product;
    }
}
