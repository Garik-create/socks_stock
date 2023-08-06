package com.skypro.home.repository;

import com.skypro.home.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsUserByUserName(String userName);

    Optional<User> findByUserName(String userName);
}
