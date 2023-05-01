package com.ani.bookingSystem.service;

import java.util.List;

import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.BookingSlotListDto;
import com.ani.bookingSystem.dto.UsersByBookingSlotDto;
import com.ani.bookingSystem.dto.UsersListDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;

public interface AdminService {

    
    List<UsersListDto> findUsers();

    List<UsersListDto> findUsers(String ss);

    List<UsersByBookingSlotDto> findUserByBookingSlot();
    
    List<UsersByBookingSlotDto> findUserByBookingSlot(String ss);
    
    Integer createBookingSlot(BookingSlotDto bookingSlot );

    List<BookingSlotListDto> findBookingSlot();

    List<BookingSlotListDto> findBookingSlot(String ss);

    Integer deleteBookingSlot(Long id)throws BookingSlotNotFoundException;

    Integer updateBookingSlot( BookingSlotDto bookingSlot);

    BookingSlotDto fetchBookingSlotDetails(Long id) throws BookingSlotNotFoundException;

    
}
