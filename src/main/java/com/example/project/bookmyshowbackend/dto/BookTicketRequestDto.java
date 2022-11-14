package com.example.project.bookmyshowbackend.dto;


import com.example.project.bookmyshowbackend.Model.ShowEntity;
import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.enums.SeatType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {

    Set<String> requestedSeats; //User will give

    int id; //user Id who is booking the ticket   :- UserEntity

    int showId; //For which show I want to book ticket :- showEntity

    SeatType seatType; //TheaterSeatEntity

}
