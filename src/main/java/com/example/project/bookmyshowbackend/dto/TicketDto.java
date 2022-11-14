package com.example.project.bookmyshowbackend.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    int id;

    String alloted_seats;

    double amount;

    ShowDto showDto;

    UserDto userDto;
}
