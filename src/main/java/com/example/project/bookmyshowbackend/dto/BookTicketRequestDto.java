package com.example.project.bookmyshowbackend.dto;


import com.example.project.bookmyshowbackend.Model.ShowEntity;
import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.enums.SeatType;

import java.util.Set;

public class BookTicketRequestDto {

    Set<String> requestedSeats; //User will give

    int id; //user Id who is booking the ticket   :- UserEntity

    int showId; //For which show I want to book ticket :- showEntity

    SeatType seatType; //TheaterSeatEntity

}
