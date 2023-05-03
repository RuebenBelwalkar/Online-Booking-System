package com.ani.bookingSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.bookingSystem.dto.AppResponse;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.dto.loginDto;
import com.ani.bookingSystem.service.UserService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/user")
@RestController
public class UserController {

    private final UserService userService;

        
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<UsersDto>>> findAll() {
        List<UsersDto> users=userService.findUsers();
        AppResponse<List<UsersDto>> response = AppResponse.<List<UsersDto>>builder()
                                                            .sts("success")
                                                            .msg("Invoices")
                                                            .bd(users)
                                                            .build();
        return ResponseEntity.ok().body(response);
    }


}
