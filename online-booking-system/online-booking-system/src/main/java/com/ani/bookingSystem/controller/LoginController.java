package com.ani.bookingSystem.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.bookingSystem.dto.AppResponse;
import com.ani.bookingSystem.dto.UserCreateDto;
import com.ani.bookingSystem.dto.loginDto;
import com.ani.bookingSystem.service.LoginService;


import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/login")
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createCustomer(@RequestBody UserCreateDto dto) {
        final Integer sts = loginService.createUser(dto);
        
        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                                                    .sts("success")
                                                    .msg("user Created Successfully")
                                                    .bd(sts)
                                                    .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        
    }

    
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<String>> loginUser(@RequestBody loginDto dto) {
         String sts = loginService.loginUser(dto);
        
        final AppResponse<String> response = AppResponse.<String>builder()
                                                    .sts("success")
                                                    .msg("user login as")
                                                    .bd(sts)
                                                    .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
