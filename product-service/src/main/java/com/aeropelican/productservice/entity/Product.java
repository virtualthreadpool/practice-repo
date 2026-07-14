package com.aeropelican.productservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "products")
@Entity
@Data
public class Product {
    @Id
    private Integer productId;
    private String productName;
    private String category;
    private Double price;
    private Integer quantity;
}
