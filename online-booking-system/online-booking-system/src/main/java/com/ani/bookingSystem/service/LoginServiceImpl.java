package com.ani.bookingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ani.bookingSystem.domain.Users;
import com.ani.bookingSystem.dto.ForgotPasswordDto;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.loginDto;
import com.ani.bookingSystem.exception.UserNotFoundException;
import com.ani.bookingSystem.repository.UsersRepository;
import com.ani.bookingSystem.util.LoginMapper;
import com.ani.bookingSystem.util.UserCreateMapper;

import lombok.AllArgsConstructor;

@Transactional
@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

  private final UsersRepository usersRepository;
  private final UserCreateMapper userCreateMapper;
  private final LoginMapper loginMapper;

  @Override
  public Integer createUser(UserCreateDto user) {
    usersRepository.save(userCreateMapper.toDomain(user));
    return 1;
  }

  @Override
  public String loginUser(loginDto dto) {

    Optional<Users> op = usersRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

    Users user = op.orElseThrow(() -> new UserNotFoundException("Email/Password is not valid"));

    return user.getRole();
  }

  @Override
  public String forgotPassword(ForgotPasswordDto dto) {
    Optional<Users> op = usersRepository.findByEmail(dto.getEmail());
    Users user = op.orElseThrow(() -> new UserNotFoundException("Email Not Found"));

    return "A link has been sent on this email" ;
  }
}
