package com.ani.bookingSystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.bookingSystem.domain.BookingSlot;
import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.UsersListDto;
import com.ani.bookingSystem.exception.BookingSlotNotFoundException;
import com.ani.bookingSystem.exception.UserNotFoundException;
import com.ani.bookingSystem.repository.AdminRepository;
import com.ani.bookingSystem.repository.UsersRepository;
import com.ani.bookingSystem.util.BookingSlotMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    private final UsersRepository usersRepository;
    private final AdminRepository adminRepository;
    private final BookingSlotMapper bookingSlotMapper;
    //to find all users detail
    @Override
    public List<UsersListDto> findUsers() {
        return usersRepository.findAll()
                            .stream()
                            .map(domain -> new UsersListDto(domain.getId(),domain.getUserName(),domain.getEmail(),domain.getCurrentLocation()))
                            .collect(Collectors.toList());
    }
    
    //to find all users details with search
    @Override
    public List<UsersListDto> findUsers(String ss) {
        return usersRepository.findUserByUserName(ss)
                            .stream()
                            .map(domain -> new UsersListDto(domain.getId(),domain.getUserName(),domain.getEmail(),domain.getCurrentLocation()))
                            .collect(Collectors.toList());
       
    }
    //the admin can delete the user account through this service
    @Override
    public Integer deleteUser(Long id) throws UserNotFoundException {
       UsersRepository.deleteById(id);
       return 1;
    }

    //the admin can update the user account through this service
    @Override
    public Integer updateUser(UserCreateDto userCreateDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    //to find one or multiple booking details of a user
    @Override
    public List<BookingSlotDto> findBookingSlotByUser(Long id) throws UserNotFoundException {
       return adminRepository.findByUser(id).stream().map(bookingSlotMapper::toDto).collect(Collectors.toList());
    }

    //the admin can create a new booking slot using this service
    @Override
    public Integer createBookingSlot(BookingSlotDto createSlot) {
       adminRepository.save(bookingSlotMapper.toDomain(createSlot));
        return 1;
       
    }
    
    //the admin can see all the booking slot created by using this service
    @Override
    public List<BookingSlotDto> findBookingSlots() {
        return adminRepository.findAll()
                               .stream()
                               .map(bookingSlotMapper::toDto)
                               .collect(Collectors.toList());
       
    }

    //the admin can see all the booking slot created by using search using this service
    @Override
    public List<BookingSlotDto> findBookingSlot(String ss) {
        return adminRepository.findBookingSlotByLocation(ss)
                              .stream()
                              .map(bookingSlotMapper::toDto)
                              .collect(Collectors.toList());
    }

    //the admin can delete the booking slots with this service
    @Override
    public Integer deleteBookingSlot(Long id) throws BookingSlotNotFoundException {
        adminRepository.deleteById(id);
        return 1;
    }

    //the admin can update the booking slots with this service
    @Override
    public Integer updateBookingSlot(BookingSlotDto updateSlot) {
        adminRepository.save(bookingSlotMapper.toDomain(updateSlot));
        return 1;
    }

    //the admin can fetch a particular booking slot for details
    @Override
    public BookingSlotDto fetchBookingSlotDetails(Long id) throws BookingSlotNotFoundException {
        Optional<BookingSlot> op = adminRepository.findById(id);
        return bookingSlotMapper.toDto(op.orElseThrow(() -> new BookingSlotNotFoundException("Invoice " + id + " Not Found")));
    }

  

    
    
}
