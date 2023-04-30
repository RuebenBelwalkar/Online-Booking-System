package com.ani.bookingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UsersFeedbackDto {
    private String comment ;
    private Double rating;
    private Long userId;
}