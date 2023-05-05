package com.ani.bookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.bookingSystem.domain.BookingSlot;
import com.ani.bookingSystem.domain.Users;
import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.LessDetailedBooking;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;
import com.ani.bookingSystem.exception.UserNotFoundException;
import com.ani.bookingSystem.repository.AdminRepository;
import com.ani.bookingSystem.repository.UsersRepository;
import com.ani.bookingSystem.util.DynamicMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final UsersRepository usersRepository;
    private final AdminRepository adminRepository;
    private final DynamicMapper dynamicMapper;

    // to find all users detail
    @Override
    public List<UsersDto> findUsers() {
        List<UsersDto> listusers = usersRepository.findAll()
                .stream()
                .map(user -> dynamicMapper.convertor(user, new UsersDto()))
                .collect(Collectors.toList());
        if (listusers.isEmpty()) {
            throw new UserNotFoundException("no Users present");
        }
        return listusers;
    }

    // to find all users details with search
    @Override
    public UsersDto findUserById(Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID " + userId));

        UsersDto userDto = new UsersDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
    

    // the admin can delete the user account through this service
    @Override
    public Integer deleteUser(Long id) throws UserNotFoundException {
        usersRepository.deleteById(id);
        return 1;
    }

    // the admin can update the user account through this service
    @Override
    public Integer updateUser(UsersDto dto) {
        isUserPresent(dto.getId());
        usersRepository.save(dynamicMapper.convertor(dto, new Users()));
        return 1;
    }

    @Override
    public Integer createBookingSlot(BookingSlotDto createSlot) {
        BookingSlot bookingSlot = dynamicMapper.convertor(createSlot, new BookingSlot());
        adminRepository.save(bookingSlot);
        return 1;

    }

    @Override
    public List<LessDetailedBooking> findBookingSlots() {
        List<LessDetailedBooking> allBookingSlots= adminRepository.findAll()
                .stream()
                .map(bookingSlot -> dynamicMapper.convertor(bookingSlot, new LessDetailedBooking()))
                .collect(Collectors.toList());
                if (allBookingSlots.isEmpty()) {
                    throw new BookingSlotNotFoundException("No Booking slots present create new one");
                }
                return allBookingSlots;

    }

    @Override
    public Integer deleteBookingSlot(Long id) throws BookingSlotNotFoundException {
        adminRepository.deleteById(id);
        return 1;

    }

    @Override
    public Integer updateBookingSlot(BookingSlotDto dto) {
        isBookingSlotPresent(dto.getId());
        adminRepository.save(dynamicMapper.convertor(dto, new BookingSlot()));
        return 1;
    }

    private void isUserPresent(Long id) {
        usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No User found for " + id + " ID"));
    }

    private void isBookingSlotPresent(Long id) {
        adminRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No Booking slot found for " + id + " ID"));
    }

    @Override
    public BookingSlotDto fetchBookingSlotDetails(Long id)  {
      
        BookingSlot bookingSlot = adminRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID " + id));

        BookingSlotDto bookingSlotDto= new BookingSlotDto();
        BeanUtils.copyProperties(bookingSlot, bookingSlotDto);
        return bookingSlotDto;
    
    }

}