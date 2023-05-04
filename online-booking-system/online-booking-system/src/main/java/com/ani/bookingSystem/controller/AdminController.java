package com.ani.bookingSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.bookingSystem.dto.AppResponse;
import com.ani.bookingSystem.dto.BookingSlotDto;
import com.ani.bookingSystem.dto.UsersDto;
import com.ani.bookingSystem.service.AdminService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/admin")
@RestController
public class AdminController {

    private final AdminService adminService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<UsersDto>>> findAllUsers() {
        List<UsersDto> users = adminService.findUsers();
        AppResponse<List<UsersDto>> response = AppResponse.<List<UsersDto>>builder()
                .sts("success")
                .msg("All users")
                .bd(users)
                .build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<UsersDto>>> findUserByid(@PathVariable Long id)  {
        List<UsersDto> users = adminService.findUsers(id);
        AppResponse<List<UsersDto>> response = AppResponse.<List<UsersDto>>builder()
                .sts("success")
                .msg("All users")
                .bd(users)
                .build();
        return ResponseEntity.ok().body(response);
    }



    @DeleteMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteUser(@PathVariable Long id) {

         Integer sts = adminService.deleteUser(id);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("User Deleted Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.status(200).body(response);

    }
    
    @PutMapping(value = "/user/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateUser(@RequestBody UsersDto dto) {

        final Integer sts = adminService.updateUser(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                                                    .sts("success")
                                                    .msg("user Updated Successfully")
                                                    .bd(sts)
                                                    .build();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/create/bookingslot", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> createBookingSlot(@RequestBody BookingSlotDto dto) {
        final Integer sts = adminService.createBookingSlot(dto);
        
        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                                                    .sts("success")
                                                    .msg("Booking slot Created Successfully")
                                                    .bd(sts)
                                                    .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
        
    }

    @GetMapping(value = "/bookingslot", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<List<BookingSlotDto>>> findAllBookingSlots() {
        List<BookingSlotDto> bookingSlot = adminService.findBookingSlots();
        AppResponse<List<BookingSlotDto>> response = AppResponse.<List<BookingSlotDto>>builder()
                .sts("success")
                .msg("All Booking slots")
                .bd(bookingSlot)
                .build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping(value = "/bookingslot/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> deleteBookingSlot(@PathVariable Long id) {

         Integer sts = adminService.deleteBookingSlot(id);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                .sts("success")
                .msg("Booking slot Deleted Successfully")
                .bd(sts)
                .build();

        return ResponseEntity.status(200).body(response);

    }
    @PutMapping(value = "/bookingslot/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse<Integer>> updateUser(@RequestBody BookingSlotDto dto) {

        final Integer sts = adminService.updateBookingSlot(dto);

        final AppResponse<Integer> response = AppResponse.<Integer>builder()
                                                    .sts("success")
                                                    .msg("BookingSlot Updated Successfully")
                                                    .bd(sts)
                                                    .build();

        return ResponseEntity.ok().body(response);
    }


}