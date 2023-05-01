package com.ani.bookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.bookingSystem.domain.BookingSlots;


public interface BookingSlotRespository extends JpaRepository<BookingSlots, Long> {
    
}
