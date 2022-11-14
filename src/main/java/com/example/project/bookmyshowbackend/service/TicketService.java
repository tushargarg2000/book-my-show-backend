package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.dto.TicketDto;

public interface TicketService {


        TicketDto getTicket(int id); //H.W (Hint is same as you do in GetMovie)

        TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);


}
