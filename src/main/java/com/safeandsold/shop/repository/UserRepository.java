package com.safeandsold.shop.repository;

import com.safeandsold.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
