package com.ani.bookingSystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserBookingDto {
    private long id;

    private long bookingId;
  
    private String location;

   
    private LocalDate startDate;

   
    private LocalDate endDate;

   
    private LocalTime startingTime; 
    
   
    private LocalTime endingTime; 

    
    private Double price; 

   
    private String airConditioning; 

   
    private Integer noOfStops; 

   
    private String serviceAvailable;

}

