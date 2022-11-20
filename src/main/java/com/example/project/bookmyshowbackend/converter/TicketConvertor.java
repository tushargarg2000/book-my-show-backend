package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.TicketEntity;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TicketResponseDto;
import com.example.project.bookmyshowbackend.dto.TicketDto;

public class TicketConvertor {

    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity){

        return TicketResponseDto.builder().id((int) ticketEntity.getId()).amount(ticketEntity.getAmount())
                .alloted_seats(ticketEntity.getAllottedSeats())
                        .build();

    }
}
