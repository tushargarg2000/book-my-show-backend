package com.example.project.bookmyshowbackend.dto;


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


    //Show Entity
   List<ShowDto> showDtoList;



}
