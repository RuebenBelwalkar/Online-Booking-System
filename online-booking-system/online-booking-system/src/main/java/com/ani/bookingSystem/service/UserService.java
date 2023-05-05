package com.ani.bookingSystem.service;

import java.util.List;
import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.FeedbackDto;
import com.ani.bookingSystem.dto.NewUserBookingDto;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.dto.UsersFeedbackDto;
import com.ani.bookingSystem.dto.loginDto;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.exception.UserNotFoundException;

public interface UserService {
    
    
    Integer createNewUserBooking(NewUserBookingDto dto);

    // Integer createUserFeedBack(UsersFeedbackDto dto);
    
    // List<FeedbackDto> listAllFeedbacks();

     List<NewUserBookingDto> findUserBookings();

    // List<UsersBookingSlotDto> findUserBookingSlot(String ss);

    // Integer deleteUserBookingSlot(Long id)throws UserNotFoundException;

    // BookingSlotDto fetchUserBookingDetails(Long id) throws UserNotFoundException;
}
