package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.example.project.bookmyshowbackend.dto.ShowDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {

    int id;
    String name;
    LocalDate releaseDate;

    //Optional
    List<ShowDto> showDtoList;
}
