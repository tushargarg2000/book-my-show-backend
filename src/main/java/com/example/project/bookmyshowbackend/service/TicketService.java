package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TicketResponseDto;
import com.example.project.bookmyshowbackend.dto.TicketDto;

public interface TicketService {


        TicketResponseDto getTicket(int id); //H.W (Hint is same as you do in GetMovie)

        TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

}
