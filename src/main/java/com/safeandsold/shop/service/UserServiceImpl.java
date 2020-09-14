package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.domain.UserStatus;
import com.safeandsold.shop.exception.UserNotFoundException;
import com.safeandsold.shop.repository.UserRepository;
import com.safeandsold.shop.service.manager.ManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, ManagerUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void deleteByIdAndPassword(Long userId, String password) {
        Optional<User> byId = this.userRepository.findById(userId);
        byId.get().setExist(false);
    }

    @Override
    public void restoreByIdAndPassword(Long userId, String password) {

    }

    @Override
    public Long saveUser(User user) {
        User save = this.userRepository.save(user);

        return save.getId();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) throws UserNotFoundException {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isEmpty()) {
            throw new UserNotFoundException();
        }
        return optional.get();
    }

    @Override
    public List<User> findByUsername(String filter) throws UserNotFoundException {
        List<User> userList = new ArrayList<>();
        if(filter != null && !filter.isEmpty()) {
            userList = userRepository.findByUsername(filter);
        } else {
            userList = userRepository.findAll();
        }

        if(userList.isEmpty()) {
            throw new UserNotFoundException();
        }

        return userList;

    }

    @Override
    public boolean editStatus(Long userId, UserStatus status) {
        return false;
    }

    @Override
    public void userDeleteRequest(Long userId) {

    }

    @Override
    public void userRestoreRequest(Long userId) {

    }

}
