package com.aeropelican.product.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private String category;
    private double price;
    private Integer quantity;
}
