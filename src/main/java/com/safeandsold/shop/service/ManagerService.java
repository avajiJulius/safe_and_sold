package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.domain.UserStatus;

import java.util.List;

public interface ManagerService {
    List<User> findUserByFilter(String filter);
    boolean editUserStatus(Long userId, UserStatus status);
    void userDeleteRequest(Long userId);
    void userRestoreRequest(Long userId);
    boolean editProductCheckStatus(Long productId);
}
