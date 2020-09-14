package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.exception.UserNotFoundException;
import com.safeandsold.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isEmpty()) {
            throw new UserNotFoundException();
        }
        return optional.get();
    }
}
