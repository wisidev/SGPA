package com.sgpa.usersgpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgpa.usersgpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
