package com.safeandsold.shop.service.user;

import com.safeandsold.shop.domain.Product;
import com.safeandsold.shop.domain.User;

public interface AuthorizedUserService {
    Long editUserProfile(User changedUser);
    Long putUpProductForSale(Product product);
    Long editProduct(Product product);

}
