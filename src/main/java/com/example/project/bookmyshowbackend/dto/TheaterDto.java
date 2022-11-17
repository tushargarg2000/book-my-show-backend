package com.example.project.bookmyshowbackend.dto;


import com.example.project.bookmyshowbackend.enums.TheaterType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDto {

    int id;

    String name;

    String address;

    String city;

    //Seats ---> You will tell me
    TheaterType type;

    //Show Entity
   List<ShowDto> showDtoList;



}
