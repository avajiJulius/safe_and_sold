package com.safeandsold.shop.service;


import com.safeandsold.shop.domain.Product;

import java.util.List;

public interface GuestService {
    List<Product> findProduct(String productName);
    Long addProductToShoppingBasket(Product product);
}
