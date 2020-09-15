package com.safeandsold.shop.service.manager;

import com.safeandsold.shop.domain.Product;


public interface ManagerProductService {
    void editCheckStatus(Long productId);
    void deleteById(Long productId);
    void saveProduct(Product product);
}
