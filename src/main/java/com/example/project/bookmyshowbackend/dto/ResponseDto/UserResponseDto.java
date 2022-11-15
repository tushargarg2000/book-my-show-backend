package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.example.project.bookmyshowbackend.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    int id;

    String name;

    String mobNo;

    //Optional
    List<TicketDto> tickets;
}
