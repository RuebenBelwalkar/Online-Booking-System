package com.ani.bookingSystem.domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Users {
    
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password; // in stars

    @Column(name = "current_location")
    private String currentLocation;

    @Column(name = "role")
    private String role;

    
    
    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    List<BookingSlot> bookingSlots;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Feedback> invoices;
}


