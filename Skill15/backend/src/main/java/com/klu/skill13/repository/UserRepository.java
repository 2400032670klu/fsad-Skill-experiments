package com.klu.skill13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.skill13.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}