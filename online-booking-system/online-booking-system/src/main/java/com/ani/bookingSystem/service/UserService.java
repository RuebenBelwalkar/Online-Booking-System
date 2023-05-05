package com.ani.bookingSystem.service;

import java.util.List;
import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.FeedbackDto;
import com.ani.bookingSystem.dto.NewUserBookingDto;
import com.ani.bookingSystem.dto.UsersDto;

import com.ani.bookingSystem.dto.loginDto;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.exception.UserNotFoundException;

public interface UserService {
    
    
    Integer createNewUserBooking(NewUserBookingDto dto);

     Integer createFeedback(FeedbackDto dto);
    
     List<FeedbackDto> listAllFeedbacks();

     List<BookingSlotDto> findUserBookings(Long id);

     Integer  deleteUserBooking(Long bookingId, Long userId);

     Integer fetchUserDetails(Long id);

     

    
}
