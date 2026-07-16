package com.aeropelican.product.service;

import com.aeropelican.product.dto.CreateProduct;
import com.aeropelican.product.dto.DeleteProduct;
import com.aeropelican.product.dto.UpdateProduct;
import com.aeropelican.product.entity.Product;
import com.aeropelican.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;
    public List<Product> list(){
        List<Product> results = productRepository.findAll();
        return results;
    }
    public  Product getProduct(Integer productId){
        return productRepository.findById(productId).get();
    }
    public Product updateProduct(Integer productId,Integer quantity) {
        Product product = productRepository.findById(productId).get();
        product.setQuantity(quantity);
        productRepository.save(product);
        return product;


    }

    public Product createProduct(CreateProduct createProduct) {
        System.out.println("Creating record in Product table..");
        Product product = new Product();
        product.setProductName(createProduct.getProductName());
        product.setCategory(createProduct.getCategory());
        product.setPrice(createProduct.getPrice());
        product.setQuantity(createProduct.getQuantity());
        Product createdProduct = productRepository.save(product);
        System.out.println("Created Product with product ID: "+createdProduct.getProductId());
        return createdProduct;

    }

    public Product updateProduct(UpdateProduct updateProduct) {
        System.out.println("Updating a record in Product table..");
        Product product = productRepository.findById(updateProduct.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(updateProduct.getProductName());
        product.setCategory(updateProduct.getCategory());
        product.setPrice(updateProduct.getPrice());
        product.setQuantity(updateProduct.getQuantity());
        Product updatedRecord = productRepository.save(product);
        System.out.println("Updated Product with product ID: "+updatedRecord.getProductId());
        return  updatedRecord;
    }

    public void deleteProduct(DeleteProduct deleteProduct) {
        System.out.println("Deleting a record in Product table...");
        Product product = productRepository.findById(deleteProduct.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
        System.out.println("Deleted Product with product ID: "+ deleteProduct.getProductId());
    }
}

