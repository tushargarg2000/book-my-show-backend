package com.example.project.bookmyshowbackend.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowDto {


    int id;

    LocalDate showDate;

    LocalTime showTime;

    @NotNull
    MovieDto movieDto;


    TheaterDto theaterDto;

}
