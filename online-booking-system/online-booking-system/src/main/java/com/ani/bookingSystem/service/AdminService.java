package com.ani.bookingSystem.service;

import java.util.List;

import com.ani.bookingSystem.dto.AdminUserBookDto;
import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.LessDetailedBooking;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;
import com.ani.bookingSystem.exception.UserNotFoundException;

public interface AdminService {

    
     List<UsersDto> findUsers();

     List<UsersDto> findUsersByUserName(String userName);

     UsersDto findUserById(Long id);

     Integer deleteUser(Long id)throws UserNotFoundException;
    
     Integer updateUser(UsersDto dto);
    
     Integer createBookingSlot(BookingSlotDto createSlot );

     List<LessDetailedBooking> findBookingSlots();

     List<LessDetailedBooking> findBookingSlotsByLocation(String location);

     Integer deleteBookingSlot(Long id)throws BookingSlotNotFoundException;

     Integer updateBookingSlot( BookingSlotDto dto);

     BookingSlotDto fetchBookingSlotDetails(Long id);

     List<AdminUserBookDto> getAllUserBookings();

     List<AdminUserBookDto> searchUserBookingsByUserName(String userName);

    
}
