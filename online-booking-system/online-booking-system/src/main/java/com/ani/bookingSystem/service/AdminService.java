package com.ani.bookingSystem.service;

import java.util.List;

import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;
import com.ani.bookingSystem.exception.UserNotFoundException;

public interface AdminService {

    
    List<UsersDto> findUsers();

    UsersDto findUserById(Long id);

    Integer deleteUser(Long id)throws UserNotFoundException;
    
    Integer updateUser(UsersDto dto);

    // List<BookingSlotDto> findBookingSlotByUser(Long id) throws UserNotFoundException;
    
     Integer createBookingSlot(BookingSlotDto createSlot );

     List<BookingSlotDto> findBookingSlots();

    // List<BookingSlotDto> findBookingSlot(String ss);

    Integer deleteBookingSlot(Long id)throws BookingSlotNotFoundException;

    Integer updateBookingSlot( BookingSlotDto dto);

    // BookingSlotDto fetchBookingSlotDetails(Long id) throws BookingSlotNotFoundException;

    
}
