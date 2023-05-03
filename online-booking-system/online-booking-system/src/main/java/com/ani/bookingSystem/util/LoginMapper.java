package com.ani.bookingSystem.util;

import org.springframework.stereotype.Component;

import com.ani.bookingSystem.domain.Users;
import com.ani.bookingSystem.dto.loginDto;

@Component
public class LoginMapper {
    
    public Users toDomain(loginDto dto){
        Users users=new Users();
        users.setEmail(dto.getEmail());
        users.setPassword(dto.getPassword());
        return users;
    }
}
