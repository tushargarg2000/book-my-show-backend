package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.TheaterEntity;
import com.example.project.bookmyshowbackend.dto.TheaterDto;

public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterDto theaterDto){

        return TheaterEntity.builder().id(theaterDto.getId()).address(theaterDto.getAddress())
                .city(theaterDto.getCity()).name(theaterDto.getName()).build();


    }

    public static TheaterDto convertEntityToDto(TheaterEntity theaterEntity){

        return TheaterDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress()).build();
    }
}
