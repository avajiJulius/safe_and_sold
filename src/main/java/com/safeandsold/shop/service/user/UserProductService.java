package com.safeandsold.shop.service.user;

import com.safeandsold.shop.domain.OrderItem;
import com.safeandsold.shop.domain.Product;

public interface UserProductService {
    Long saveProduct(Product product);
    boolean addProductToOrder(OrderItem item);
}
