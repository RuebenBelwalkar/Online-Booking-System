package com.ani.bookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.bookingSystem.domain.BookingSlot;
import com.ani.bookingSystem.domain.Users;
import com.ani.bookingSystem.dto.NewUserBookingDto;
// import com.ani.bookingSystem.domain.Feedback;
// import com.ani.bookingSystem.domain.Users;
// import com.ani.bookingSystem.dto.BookingSlotDto;
// import com.ani.bookingSystem.dto.FeedbackDto;
import com.ani.bookingSystem.dto.UserCreateDto;

import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.dto.loginDto;

import com.ani.bookingSystem.exception.UserNotFoundException;
import com.ani.bookingSystem.repository.AdminRepository;
import com.ani.bookingSystem.repository.FeedbackRepository;
import com.ani.bookingSystem.repository.UsersRepository;
import com.ani.bookingSystem.util.BookingSlotMapper;
import com.ani.bookingSystem.util.DynamicMapper;
import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service

public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final AdminRepository adminRepository;
    private final DynamicMapper dynamicMapper;

    @Override
    public Integer createNewUserBooking(NewUserBookingDto dto) {
        Users user = usersRepository.findById(dto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("No Id found"));
        BookingSlot bookingSlot = new BookingSlot();
        BeanUtils.copyProperties(dto, bookingSlot);
        // user.getBookingSlots().add(bookingSlot);
        bookingSlot.getUsers().add(user);
        adminRepository.save(bookingSlot);
        return 1;

    }

    @Override
    public List<NewUserBookingDto> findUserBookings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserBookings'");
    }

}