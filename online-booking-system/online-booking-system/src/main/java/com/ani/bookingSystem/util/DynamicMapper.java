package com.ani.bookingSystem.util;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import com.ani.bookingSystem.domain.Users;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.loginDto;
@Component
public class DynamicMapper {

    public <T, U> U convertor(T entity, U dto) {
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
    public Users toDomain(loginDto dto){
        Users users=new Users();
        users.setEmail(dto.getEmail());
        users.setPassword(dto.getPassword());
        return users;
    }
}  