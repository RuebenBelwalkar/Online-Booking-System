package com.ani.bookingSystem.controller;

import java.util.List;

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
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.service.AdminService;


import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/admin")
@RestController
public class AdminController{

    private final AdminService adminService;
    
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<UsersDto>>> findAll() {
        List<UsersDto> users=adminService.findUsers();
        AppResponse<List<UsersDto>> response = AppResponse.<List<UsersDto>>builder()
                                                            .sts("success")
                                                            .msg("All users")
                                                            .bd(users)
                                                            .build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<UsersDto>>> findAllByUsername(@PathVariable String ss) {
        List<UsersDto> users=adminService.findUsers(ss);
        AppResponse<List<UsersDto>> response = AppResponse.<List<UsersDto>>builder()
                                                            .sts("success")
                                                            .msg("All users")
                                                            .bd(users)
                                                            .build();
        return ResponseEntity.ok().body(response);
    }



}