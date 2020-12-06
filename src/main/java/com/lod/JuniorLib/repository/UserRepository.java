package com.lod.JuniorLib.repository;

import com.lod.JuniorLib.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
