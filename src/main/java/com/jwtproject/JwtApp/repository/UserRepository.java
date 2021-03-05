package com.jwtproject.JwtApp.repository;

import com.jwtproject.JwtApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
}
