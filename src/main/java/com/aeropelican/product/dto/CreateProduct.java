package com.aeropelican.product.dto;

import lombok.Data;
@Data
public class CreateProduct {
    private Integer productId;
    private String productName;
    private String category;
    private double price;
    private Integer quantity;
}
