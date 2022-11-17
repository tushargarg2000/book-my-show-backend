package com.example.project.bookmyshowbackend.dto.EntryRequest;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheaterEntryDto {

    String name;
    String address;
    String city;

}
