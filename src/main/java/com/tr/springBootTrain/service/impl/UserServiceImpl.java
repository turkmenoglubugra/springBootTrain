package com.tr.springBootTrain.service.impl;

import com.tr.springBootTrain.dto.UserDto;
import com.tr.springBootTrain.entity.User;
import com.tr.springBootTrain.repository.UserRepository;
import com.tr.springBootTrain.service.UserService;
import com.tr.springBootTrain.util.CustomPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        } else {
            return null;
        }
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        Optional<User> resultUser = userRepository.findById(id);
        if (resultUser.isPresent()) {
            resultUser.get().setName(userDto.getName());
            resultUser.get().setSurname(userDto.getSurname());
            resultUser.get().setUpdatedBy("Admin");
            resultUser.get().setUpdatedDate(new Date());
            return modelMapper.map(userRepository.save(resultUser.get()), UserDto.class);
         } else {
            return null;
        }
    }

    @Override
    public Boolean removeUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<User> pagination(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Slice<User> slice(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public CustomPage<UserDto> customPagination(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        UserDto[] dtos = modelMapper.map(data.getContent(), UserDto[].class);
        return new CustomPage<>(data, Arrays.asList(dtos));
    }
}
