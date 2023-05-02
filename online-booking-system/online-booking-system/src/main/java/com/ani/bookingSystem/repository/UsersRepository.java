package com.ani.bookingSystem.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.bookingSystem.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findUserByUserName(String ss);
}
