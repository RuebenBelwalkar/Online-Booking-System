package com.ani.bookingSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.bookingSystem.domain.Users;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.loginDto;
import com.ani.bookingSystem.repository.UsersRepository;
import com.ani.bookingSystem.util.DynamicMapper;
import com.ani.bookingSystem.util.UserCreateMapper;


import lombok.AllArgsConstructor;



@Transactional
@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService{

    private final UsersRepository usersRepository;
    private final UserCreateMapper userCreateMapper;
    private final DynamicMapper dynamicMapper;
    
    @Override
    public Integer createUser(UserCreateDto user) {
      usersRepository.save(userCreateMapper.toDomain(user));
      return 1;
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
}
