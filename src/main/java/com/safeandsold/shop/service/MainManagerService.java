package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.request.UserDeleteRequest;
import com.safeandsold.shop.domain.request.UserRestoreRequest;

public interface MainManagerService {
    Long deleteUser(UserDeleteRequest request);
    Long restoreUser(UserRestoreRequest request);
}
