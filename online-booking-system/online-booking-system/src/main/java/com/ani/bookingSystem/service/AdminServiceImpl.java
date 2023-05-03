package com.ani.bookingSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.bookingSystem.domain.BookingSlot;
import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;
import com.ani.bookingSystem.exception.UserNotFoundException;
import com.ani.bookingSystem.repository.AdminRepository;
import com.ani.bookingSystem.repository.UsersRepository;
import com.ani.bookingSystem.util.BookingSlotMapper;
import com.ani.bookingSystem.util.UserMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final UsersRepository usersRepository;
    private final AdminRepository adminRepository;
    private final BookingSlotMapper bookingSlotMapper;
    private final UserMapper userMapper;
    
    //to find all users detail
    @Override
    public List<UsersDto> findUsers() {
        return usersRepository.findAll()
                            .stream()
                            .map(userMapper::toDto)
                            .collect(Collectors.toList());
    }

    //to find all users details with search
    @Override
    public List<UsersDto> findUsers(String ss) {
        return usersRepository.findUserByUserName(ss)
                            .stream()
                            .map(userMapper::toDto)
                            .collect(Collectors.toList());
       
    }
    //the admin can delete the user account through this service
    @Override
    public Integer deleteUser(Long id) throws UserNotFoundException {
       usersRepository.deleteById(id);
       return 1;
    }

    //the admin can update the user account through this service
    @Override
    public Integer updateUser(UsersDto usersdto) {
       usersRepository.save(userMapper.toDomain(usersdto));
       return 1;
    }

    @Override
    public Integer createBookingSlot(BookingSlotDto createSlot) {
       adminRepository.save(bookingSlotMapper.toDomain(createSlot));
        return 1;
       
    }

   
}