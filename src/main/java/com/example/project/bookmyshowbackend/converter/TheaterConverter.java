package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.TheaterEntity;
import com.example.project.bookmyshowbackend.dto.EntryRequest.TheaterEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TheaterResponseDto;

public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        return TheaterEntity.builder().address(theaterEntryDto.getAddress())
                .city(theaterEntryDto.getCity()).name(theaterEntryDto.getName()).build();


    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity){

        return TheaterResponseDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress())
                .type(theaterEntity.getType())
                .build();
    }
}
