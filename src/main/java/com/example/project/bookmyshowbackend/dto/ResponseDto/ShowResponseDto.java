package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponseDto {


    int id;

    LocalDate showDate;

    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    TheaterResponseDto theaterDto;

}
