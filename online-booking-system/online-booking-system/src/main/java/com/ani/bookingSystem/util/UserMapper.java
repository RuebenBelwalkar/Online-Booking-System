package com.ani.bookingSystem.util;
import org.springframework.stereotype.Component;

import com.ani.bookingSystem.domain.Users;
import com.ani.bookingSystem.dto.UsersDto;

@Component
public class UserMapper {
    public Users toDomain(UsersDto dto) {

        return Users.builder()
                        .id(dto.getId())
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .currentLocation(dto.getCurrentLocation())
                        .build();
    }

    public UsersDto toDto(Users domain) {
        return new UsersDto(domain.getId(),
                                 domain.getUserName(),
                                 domain.getEmail(),
                                 domain.getCurrentLocation());
    }
}
                                
