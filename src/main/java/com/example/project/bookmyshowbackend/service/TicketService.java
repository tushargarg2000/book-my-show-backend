package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.dto.TicketDto;

public interface TicketService {


        TicketDto getTicket(int id);

        TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);


}
