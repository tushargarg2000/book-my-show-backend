package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.EntryRequest.UserEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.UserResponseDto;
import com.example.project.bookmyshowbackend.dto.UserDto;

public interface UserService { //Designing part

    void addUser(UserEntryDto userEntryDto);

    UserResponseDto getUser(int id);


}
