package com.ani.bookingSystem.util;

import org.springframework.stereotype.Component;

import com.ani.bookingSystem.domain.Users;
import com.ani.bookingSystem.dto.UserCreateDto;

@Component
public class UserCreateMapper {
    public Users toDomain(UserCreateDto dto) {

        return Users.builder()
                        .id(dto.getId())
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .currentLocation(dto.getCurrentLocation())
                        .role(dto.getRole())
                        .build();
    }

    public UserCreateDto toDto(Users domain) {
        return new UserCreateDto(domain.getId(),
                                 domain.getUserName(),
                                 domain.getEmail(),
                                 domain.getPassword(),
                                 domain.getCurrentLocation(),
                                 domain.getRole());
    }
}
