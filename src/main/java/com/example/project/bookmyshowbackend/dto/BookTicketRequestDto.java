package com.example.project.bookmyshowbackend.dto;


import com.example.project.bookmyshowbackend.Model.ShowEntity;
import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.enums.SeatType;

import java.util.Set;

public class BookTicketRequestDto {

    Set<String> requestedSeats;

    int id;

    int showId;

    SeatType seatType;

}
