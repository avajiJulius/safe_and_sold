package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.Product;
import com.safeandsold.shop.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
    Product findById(Long productId) throws ProductNotFoundException;
    List<Product> findByPrice(Integer minPrice, Integer maxPrice) throws ProductNotFoundException;
    List<Product> findByProductName(String productName) throws ProductNotFoundException;
    void deleteById(Long productId);
    void saveProduct(Product product);
}
