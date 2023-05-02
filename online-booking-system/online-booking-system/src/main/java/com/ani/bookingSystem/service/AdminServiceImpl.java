package com.ani.bookingSystem.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.BookingSlotListDto;
import com.ani.bookingSystem.dto.UsersByBookingSlotDto;
import com.ani.bookingSystem.dto.UsersListDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;
import com.ani.bookingSystem.repository.AdminRespository;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRespository adminRespository;
    @Override
    public List<UsersListDto> findUsers() {
        return adminRespository.findAll()
                                .stream()
                                .map(domain -> new UsersListDto(domain.getId(),domain.getUsername()))
                                .collect(Collector.toList());
    }

    @Override
    public List<UsersListDto> findUsers(String ss) {
       
    }

    @Override
    public List<UsersByBookingSlotDto> findUserByBookingSlot() {
       
    }

    @Override
    public List<UsersByBookingSlotDto> findUserByBookingSlot(String ss) {
      
    }

    @Override
    public Integer createBookingSlot(BookingSlotDto bookingSlot) {
       
    }

    @Override
    public List<BookingSlotListDto> findBookingSlot() {
       
    }

    @Override
    public List<BookingSlotListDto> findBookingSlot(String ss) {
       
    }

    @Override
    public Integer deleteBookingSlot(Long id) throws BookingSlotNotFoundException {
        
    }

    @Override
    public Integer updateBookingSlot(BookingSlotDto bookingSlot) {
        
    }

    @Override
    public BookingSlotDto fetchBookingSlotDetails(Long id) throws BookingSlotNotFoundException {
       
    }
    
}
