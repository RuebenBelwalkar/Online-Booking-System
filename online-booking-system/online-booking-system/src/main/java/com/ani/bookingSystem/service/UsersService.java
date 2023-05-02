package com.ani.bookingSystem.service;

import java.util.List;
import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.UsersBookingSlotDto;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.exception.UserNotFoundException;

public interface UsersService {
    
    Integer createUser(UserCreateDto user);

    List<UsersBookingSlotDto> findUserBookingSlot();

    List<UsersBookingSlotDto> findUserBookingSlot(String ss);

    Integer deleteUserBookingSlot(Long id)throws UserNotFoundException;

    BookingSlotDto fetchUserBookingDetails(Long id) throws UserNotFoundException;
}
