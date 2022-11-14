package com.example.project.bookmyshowbackend.dto;

import lombok.*;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    int id;

    String name;

    LocalDate releaseDate;

    List<ShowDto> showDtoList;
}
