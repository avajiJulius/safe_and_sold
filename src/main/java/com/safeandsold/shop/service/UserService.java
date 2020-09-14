package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id) throws UserNotFoundException;

}
