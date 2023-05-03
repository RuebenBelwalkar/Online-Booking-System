package com.ani.bookingSystem.dto;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
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
public class BookingSlotDto {
    private Long id;

    @NotEmpty(message = "Location cant be empty")
    @NotNull(message = "Location cant be null")
    @NotBlank(message = "Location cant be blank")
    private String location;

    @NotEmpty(message = "Start date cant be empty")
    @NotNull(message = "Start date cant be null")
    @NotBlank(message = "Start date cant be blank")
    private LocalDate startDate;

    @NotEmpty(message = "end date cant be empty")
    @NotNull(message = "end date cant be null")
    @NotBlank(message = "end date  cant be blank")
    private LocalDate endDate;

    @NotEmpty(message = "Starting time cant be empty")
    @NotNull(message = "Starting time cant be null")
    @NotBlank(message = "Starting time cant be blank")
    private LocalTime startingTime; 
    
    @NotEmpty(message = "Ending date cant be empty")
    @NotNull(message = "Ending date cant be null")
    @NotBlank(message = "Ending date cant be blank")
    private LocalTime endingTime; 

    @NotEmpty(message = "Price cant be empty")
    @NotNull(message = "Price cant be null")
    @NotBlank(message = "Price cant be blank")
    private Double price; 

    @NotEmpty(message = "Air conditioning cant be empty")
    @NotNull(message = "Air conditioning cant be null")
    @NotBlank(message = "Air conditioning cant be blank")
    private String airConditioning; 

    @NotEmpty(message = "No of stops cant be empty")
    @NotNull(message = "No of stops cant be null")
    @NotBlank(message = "No of stops cant be blank")
    private Integer noOfStops; 

    @NotEmpty(message = "Service available cant be empty")
    @NotNull(message = " Service available cant be null")
    @NotBlank(message = "Service available cant be blank")
    private String serviceAvailable;

    
    
    
    
}


