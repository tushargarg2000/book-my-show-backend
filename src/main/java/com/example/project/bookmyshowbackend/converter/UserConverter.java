package com.example.project.bookmyshowbackend.converter;


import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.dto.UserDto;

import java.util.Optional;

public class UserConverter {


    public static UserEntity convertDtoToEntity(UserDto userDto){

        //I need to create the User
        return UserEntity.builder().name(userDto.getName()).mobile(userDto.getMobileNo()).build();
    }

    public static UserDto convertEntityToDto(UserEntity user){

        return UserDto.builder().id(user.getId()).name(user.getName()).mobileNo(user.getMobile()).build();

    }



}
