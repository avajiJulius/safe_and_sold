package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
    Product findById(Long productId);
    List<Product> findByPrice(Integer minPrice, Integer maxPrice);
    List<Product> findByProductName(String productName);

}
