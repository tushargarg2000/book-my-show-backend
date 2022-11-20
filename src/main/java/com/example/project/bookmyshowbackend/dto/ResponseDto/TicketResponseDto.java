package com.example.project.bookmyshowbackend.dto.ResponseDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {


    int id;

    String alloted_seats;
    double amount;

}
