package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.EntryRequest.MovieEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieNameAndIdObject;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    //Add movie
    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);


    //get movie
    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);


}
