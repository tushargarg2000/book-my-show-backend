package com.example.project.bookmyshowbackend.dto;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    int id;

    String alloted_seats;

    double amount;

    ShowDto showDto;

    @NotNull
    UserDto userDto; //Mandatory for me to fill this userDto Value
}
