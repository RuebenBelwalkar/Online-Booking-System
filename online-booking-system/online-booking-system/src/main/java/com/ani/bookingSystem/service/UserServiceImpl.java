package com.ani.bookingSystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.bookingSystem.domain.Users;
// import com.ani.bookingSystem.domain.BookingSlot;
// import com.ani.bookingSystem.domain.Feedback;
// import com.ani.bookingSystem.domain.Users;
// import com.ani.bookingSystem.dto.BookingSlotDto;
// import com.ani.bookingSystem.dto.FeedbackDto;
import com.ani.bookingSystem.dto.UserCreateDto;
//import com.ani.bookingSystem.dto.UsersBookingSlotDto;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.dto.loginDto;
//import com.ani.bookingSystem.dto.UsersFeedbackDto;
//import com.ani.bookingSystem.exception.UserNotFoundException;
import com.ani.bookingSystem.repository.AdminRepository;
import com.ani.bookingSystem.repository.FeedbackRepository;
import com.ani.bookingSystem.repository.UsersRepository;
import com.ani.bookingSystem.util.BookingSlotMapper;
import com.ani.bookingSystem.util.DynamicMapper;
import com.ani.bookingSystem.util.FeedbackMapper;
import com.ani.bookingSystem.util.UserCreateMapper;
import com.ani.bookingSystem.util.UserMapper;
import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service


public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    private final AdminRepository adminRepository;
    private final FeedbackRepository feedbackRepository;
    private final BookingSlotMapper bookingSlotMapper;
    private final UserMapper userMapper;
    private final UserCreateMapper userCreateMapper;
    private final FeedbackMapper feedbackMapper;
    private final DynamicMapper dynamicMapper;
    @Override
    public Integer createUser(UserCreateDto user) {
      usersRepository.save(userCreateMapper.toDomain(user));
      return 1;
    }

    // @Override
    // public Integer creatNewUserBooking(UsersBookingSlotDto dto) {
    //     Users users=usersRepository.findById(dto.getUserId())
    //                                 .orElseThrow(()-> new UserNotFoundException("User not found"));

    // BookingSlot bookingSlot=new BookingSlot();
    //     bookingSlot.setLocation(dto.getLocation());
    //     bookingSlot.setStartDate(dto.getStartDate());
    //     bookingSlot.setEndDate(dto.getEndDate());
    //     bookingSlot.setStartingTime(dto.getStartingTime());
    //     bookingSlot.setEndingTime(dto.getEndingTime());
    //     bookingSlot.setPrice(dto.getPrice());
    //     bookingSlot.setAirConditioning(dto.getAirConditioning());
    //     bookingSlot.setNoOfStops(dto.getNoOfStops());
    //     bookingSlot.setServiceAvailable(dto.getServiceAvailable());
    //     bookingSlot.setUsers(users);;
    //     usersRepository.save(bookingSlot);
    //     return 1;
    //}


    

    // @Override
    // public Integer createUserFeedBack(UsersFeedbackDto dto) {
    //     Users users=usersRepository.findById(dto.getUserId())
    //                                .orElseThrow(()->new UserNotFoundException("User not found"));
    
    //     Feedback feedback=new Feedback();
    //     feedback.setComment(dto.getComment());
    //     feedback.setRating(dto.getRating());
    //     feedback.setUsers(users);
    //     feedbackRepository.save(feedback);
    //     return 1;
        
    // }
    // @Override
    // public List<FeedbackDto> listAllFeedbacks() {
    //     return feedbackRepository.findAll()
    //                              .stream()
    //                              .map(feedbackMapper::toDto)
    //                              .collect(Collectors.toList());
        
    // }


    // @Override
    // public List<UsersBookingSlotDto> findUserBookingSlot() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'findUserBookingSlot'");
    // }

    // @Override
    // public List<UsersBookingSlotDto> findUserBookingSlot(String ss) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'findUserBookingSlot'");
    // }

    // @Override
    // public Integer deleteUserBookingSlot(Long id) throws UserNotFoundException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteUserBookingSlot'");
    // }

    // @Override
    // public BookingSlotDto fetchUserBookingDetails(Long id) throws UserNotFoundException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'fetchUserBookingDetails'");
    // }
     @Override
     public List<UsersDto> findUsers() {
        return usersRepository.findAll()
                            .stream()
                            .map(userMapper::toDto)
                            .collect(Collectors.toList());
    }

    @Override
    public String loginUser(loginDto dto) {
    Users user=dynamicMapper.toDomain(dto);
    List<Users> users = usersRepository.findAll();
    for(Users users2:users){
      if(user.getEmail().equals(users2.getEmail())&&user.getPassword().equals(users2.getPassword())){
       
            return users2.getRole();
      }
    }
    return "invalid user";

    }
      //
    // @Override
    // public Integer creatNewUserBooking(UsersBookingSlotDto dto) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'creatNewUserBooking'");
    // }
    
}

    
   



  
