package com.ani.bookingSystem.service;

import java.util.List;

import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;
import com.ani.bookingSystem.exception.UserNotFoundException;

public interface AdminService {

    
    List<UsersDto> findUsers();

    List<UsersDto> findUsers(String ss);

    Integer deleteUser(Long id)throws UserNotFoundException;
    
    Integer updateUser(UsersDto usersDto);

    // List<BookingSlotDto> findBookingSlotByUser(Long id) throws UserNotFoundException;
    
     Integer createBookingSlot(BookingSlotDto bookingSlot );

    // List<BookingSlotDto> findBookingSlots();

    // List<BookingSlotDto> findBookingSlot(String ss);

    // Integer deleteBookingSlot(Long id)throws BookingSlotNotFoundException;

    // Integer updateBookingSlot( BookingSlotDto bookingSlot);

    // BookingSlotDto fetchBookingSlotDetails(Long id) throws BookingSlotNotFoundException;

    
}
