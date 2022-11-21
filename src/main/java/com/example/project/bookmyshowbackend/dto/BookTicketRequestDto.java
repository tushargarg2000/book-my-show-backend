package com.example.project.bookmyshowbackend.dto;


import com.example.project.bookmyshowbackend.Model.ShowEntity;
import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.enums.SeatType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {

    Set<String> requestedSeats; //User will give

     //user Id who is booking the ticket   :- UserEntity

    int showId; //For which show I want to book ticket :- showEntity

    int id; //userId


    SeatType seatType; //TheaterSeatEntity

}
