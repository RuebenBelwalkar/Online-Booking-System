package com.ani.bookingSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.bookingSystem.domain.Users;

public interface UsersRespository extends JpaRepository<Users, Long> {
    
}
