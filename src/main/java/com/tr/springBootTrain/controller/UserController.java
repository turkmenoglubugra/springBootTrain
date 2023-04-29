package com.tr.springBootTrain.controller;

import com.tr.springBootTrain.dto.UserDto;
import com.tr.springBootTrain.entity.User;
import com.tr.springBootTrain.service.UserService;
import com.tr.springBootTrain.util.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto resultUser = userService.createUser(userDto);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>>  getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto>  getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto>  updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        UserDto resultUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> removeUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.removeUser(id));
    }

    @GetMapping("/pagination")
    public  ResponseEntity<Page<User>> pagination(Pageable pageable){
        return ResponseEntity.ok(userService.pagination(pageable));
    }

    @GetMapping("/customPagination")
    public  ResponseEntity<CustomPage<UserDto>> customPagination(Pageable pageable){
        return ResponseEntity.ok(userService.customPagination(pageable));
    }

    @GetMapping("/slice")
    public  ResponseEntity<Slice<User>> slice(Pageable pageable){
        return ResponseEntity.ok(userService.slice(pageable));
    }

}
