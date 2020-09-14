package com.safeandsold.shop.service.manager.main;

import com.safeandsold.shop.domain.request.UserDeleteRequest;
import com.safeandsold.shop.domain.request.UserRestoreRequest;

public interface MainManagerService {
    Long deleteUser(UserDeleteRequest request);
    Long restoreUser(UserRestoreRequest request);
}
