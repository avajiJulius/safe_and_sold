package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.User;

public interface UserService {
    void deleteByIdAndPassword(Long userId, String password);
    void restoreByIdAndPassword(Long userId, String password);
    Long saveUser(User user);
}
