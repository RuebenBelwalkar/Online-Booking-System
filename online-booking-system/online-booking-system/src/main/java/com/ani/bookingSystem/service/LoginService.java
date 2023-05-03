package com.ani.bookingSystem.service;

import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.loginDto;

public interface LoginService {
    
    Integer createUser(UserCreateDto user);

    String loginUser (loginDto dto) ;
}
