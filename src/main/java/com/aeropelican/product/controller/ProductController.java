package com.aeropelican.product.controller;

import com.aeropelican.product.dto.CreateProduct;
import com.aeropelican.product.dto.DeleteProduct;
import com.aeropelican.product.dto.UpdateProduct;
import com.aeropelican.product.entity.Product;
import com.aeropelican.product.repository.ProductRepository;
import com.aeropelican.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    public ProductService productService;
    @GetMapping
    public List<Product> getProducts() {
        List<Product> result = productService.list();
        return result;
    }
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Integer productId){
        return productService.getProduct(productId);
    }
    /*@PutMapping("/{productId}/{quantity}")
    public Product updateProduct(@PathVariable("productId") Integer productId ,@PathVariable("quantity") Integer quantity){
        return productService.updateProduct(productId,quantity);
    }*/
    @PostMapping()
    public ResponseEntity<Product>createProduct(@RequestBody CreateProduct createProduct){
        System.out.println("Receiving a post request from user..");
        Product product = productService.createProduct(createProduct);
        return ResponseEntity.ok(product);

    }
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@RequestBody UpdateProduct updateProduct) {
        System.out.println("Requesting to update a record..");
        updateProduct.setProductId(productId);
        Product product = productService.updateProduct(updateProduct);

        return ResponseEntity.ok(product);
    }
        @DeleteMapping("/{productId}")
        public void deleteProduct(@PathVariable Integer productId) {
            System.out.println("Requesting to delete a product...");
            DeleteProduct deleteProduct = new DeleteProduct();
            deleteProduct.setProductId(productId);
            productService.deleteProduct(deleteProduct);
        }

}
/*public class ProductController {

    @GetMapping("/")
    public  String welcome(@RequestParam("name")String name){
        System.out.println("Hello "+name);
        return "Application is running";
    }*/


