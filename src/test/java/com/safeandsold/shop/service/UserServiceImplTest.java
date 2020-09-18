package com.safeandsold.shop.service;

import com.safeandsold.shop.domain.Role;
import com.safeandsold.shop.domain.User;
import com.safeandsold.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {


    private UserRepository userRepository;

    @Test
    void deleteByIdAndPassword() {
    }

    @Test
    void restoreByIdAndPassword() {
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUsername("avaji");
        user.setFirstName("Julius");
        user.setLastName("Avaji");
        user.setPatronymic("Eduardovich");
        user.setEmail("avajiJulius@gmail.com");
        user.setPassword("123");
        user.setRoles(Collections.singleton(Role.USER));
        user.setDateOfBirth(LocalDate.of(2000, 02, 12));
        user.setActive(true);
        user.setExist(true);
        userRepository.save(user);
    }

    @Test
    void findAllUsers() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void userDeleteRequest() {
    }

    @Test
    void userRestoreRequest() {
    }
}