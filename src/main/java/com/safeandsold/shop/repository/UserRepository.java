package com.safeandsold.shop.repository;

import com.safeandsold.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    @Query(name = "User.findById",
    value = "select u from User u where u.id = :id")
    Optional<User> findById(@Param("id") Long id);
    @Query(name = "User.findByUsername",
    value = "select u from User u where upper(u.username) = upper(:username)")
    List<User> findByUsername(@Param("username") String username);
}
