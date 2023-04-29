package com.tr.springBootTrain.service;

import com.tr.springBootTrain.dto.UserDto;
import com.tr.springBootTrain.entity.User;
import com.tr.springBootTrain.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    List<UserDto> getUsers();

    UserDto getUser(Long id);
    UserDto updateUser(Long id, UserDto user);

    Boolean removeUser(Long id);
    Page<User> pagination(Pageable pageable);
    Slice<User> slice(Pageable pageable);
    CustomPage<UserDto> customPagination(Pageable pageable);
}
