package com.safeandsold.shop.service.manager;

import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.domain.UserStatus;
import com.safeandsold.shop.exception.UserNotFoundException;


import java.util.List;

public interface ManagerUserService
{
    List<User> findAllUsers();
    User findById(Long id) throws UserNotFoundException;
    List<User> findByUsername(String filter) throws UserNotFoundException;
    boolean editStatus(Long userId, UserStatus status);
    void userDeleteRequest(Long userId);
    void userRestoreRequest(Long userId);
}
