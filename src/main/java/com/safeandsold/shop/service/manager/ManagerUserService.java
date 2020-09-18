package com.safeandsold.shop.service.manager;

import com.safeandsold.shop.domain.User;

import java.util.List;

public interface ManagerUserService
{
    List<User> findAllUsers();
    User findById(Long id);
    List<User> findByUsername(String filter);
    void userDeleteRequest(Long userId);
    void userRestoreRequest(Long userId);
}
