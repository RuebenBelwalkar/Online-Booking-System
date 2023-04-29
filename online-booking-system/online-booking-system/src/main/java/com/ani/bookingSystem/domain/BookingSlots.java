package com.ani.bookingSystem.domain;
import java.time.LocalTime;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity
public class BookingSlots {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "starting_time")
    private LocalTime startingTime;   

    @Column(name = "ending_time")
    private LocalTime endingTime; 

    @Column(name = "price")
    private Double price; 

    @Column(name = "air_conditioning")
    private String airConditioning; 

    @Column(name = "no_of_stops")
    private Integer noOfStops; 

    @Column(name = "service_available")
    private String serviceAvailable; 
}

