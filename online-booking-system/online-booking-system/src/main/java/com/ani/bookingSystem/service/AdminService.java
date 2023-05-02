package com.ani.bookingSystem.service;

import java.util.List;

import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.UsersBookingSlotDto;
import com.ani.bookingSystem.dto.UsersByBookingSlotDto;
import com.ani.bookingSystem.dto.UsersCreateDto;
import com.ani.bookingSystem.dto.UsersListDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;
import com.ani.bookingSystem.exception.UserNotFoundException;

public interface AdminService {

    
    List<UsersListDto> findUsers();

    List<UsersListDto> findUsers(String ss);

    Integer deleteUser(Long id)throws UserNotFoundException;
    
    Integer updateUser(UserCreateDto userCreateDto);

    List<BookingSlotDto> findBookingSlotByUser(Long id) throws UserNotFoundException;
    
    Integer createBookingSlot(BookingSlotDto bookingSlot );

    List<BookingSlotDto> findBookingSlots();

    List<BookingSlotDto> findBookingSlot(String ss);

    Integer deleteBookingSlot(Long id)throws BookingSlotNotFoundException;

    Integer updateBookingSlot( BookingSlotDto bookingSlot);

    BookingSlotDto fetchBookingSlotDetails(Long id) throws BookingSlotNotFoundException;

    
}
