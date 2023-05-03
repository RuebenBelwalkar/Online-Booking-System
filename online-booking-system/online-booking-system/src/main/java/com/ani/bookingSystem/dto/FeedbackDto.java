package com.ani.bookingSystem.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

public class FeedbackDto {
    private Long id;
    private String comment;
    private Double rating;
}