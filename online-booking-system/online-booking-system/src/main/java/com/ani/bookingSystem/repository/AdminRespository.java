package com.ani.bookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.bookingSystem.domain.BookingSlot;


public interface AdminRespository extends JpaRepository<BookingSlot, Long> {
    
}
