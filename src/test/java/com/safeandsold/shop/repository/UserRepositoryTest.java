package com.safeandsold.shop.repository;

import com.safeandsold.shop.domain.Role;
import com.safeandsold.shop.domain.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;
    @Test
    void findAll() {

    }

    @Test
    void findById() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void save() {
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
        assertNotEquals(null, user);
    }
}