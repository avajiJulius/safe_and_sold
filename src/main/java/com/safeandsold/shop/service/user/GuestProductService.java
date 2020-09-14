package com.safeandsold.shop.service.user;

import com.safeandsold.shop.domain.Product;

import java.util.List;

public interface GuestProductService {
    List<Product> findProduct(String productName);
    Long addProductToShoppingBasket(Product product);
}
