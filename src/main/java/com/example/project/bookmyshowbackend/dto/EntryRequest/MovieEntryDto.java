package com.example.project.bookmyshowbackend.dto.EntryRequest;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@Builder
public class MovieEntryDto { //Dtos are built to avoid heavy api calling bcz they contain only required parameters

    String name;
    LocalDate releaseDate;
}
