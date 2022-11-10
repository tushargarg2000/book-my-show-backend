package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.TheaterDto;

public interface TheaterService {


    TheaterDto addTheater(TheaterDto theaterDto);

    TheaterDto getTheater(int id);

}
