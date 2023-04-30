package com.ani.bookingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsersListDto {
    private Long id;
    private String userName;
    private String email;
    private String currentLocation; 
}