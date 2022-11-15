package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.ShowEntity;
import com.example.project.bookmyshowbackend.Model.ShowSeatsEntity;
import com.example.project.bookmyshowbackend.Model.TicketEntity;
import com.example.project.bookmyshowbackend.Model.UserEntity;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.TicketRepository;
import com.example.project.bookmyshowbackend.Repository.UserRepository;
import com.example.project.bookmyshowbackend.converter.TicketConvertor;
import com.example.project.bookmyshowbackend.dto.BookTicketRequestDto;
import com.example.project.bookmyshowbackend.dto.TicketDto;
import com.example.project.bookmyshowbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketDto getTicket(int id) {
        return null;
    }

    @Override
    public TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {


        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();
        Set<String> requestSeats = bookTicketRequestDto.getRequestedSeats();
        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getSeats();


        //Option 1
        List<ShowSeatsEntity> bookedSeats = showSeatsEntityList
                .stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&!seat.isBooked()&&
                        requestSeats.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());


        //Option 2
//        List<ShowSeatsEntity> bookedSeats1 = new ArrayList<>();
//
//        for(ShowSeatsEntity seat :showSeatsEntityList){
//
//            if(!seat.isBooked()&&seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&requestSeats.contains(seat.getSeatNumber())){
//                bookedSeats1.add(seat);
//            }
//        }

        if(bookedSeats.size()!=requestSeats.size()){
            //Al the seats were not avaiable
            throw new Error("All Seats not available");
        }

        //Step 2

        TicketEntity ticketEntity = TicketEntity.builder().
        userNameBlahBlah(userEntity)
                .show(showEntity)
                        .seats(bookedSeats).
                build();



        //Step 3 :

        double amount = 0;

        for(ShowSeatsEntity showSeatsEntity: bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setAllottedSeats(String.valueOf(bookedSeats));
        ticketEntity.setAmount(amount);


        //Connect in thw Show and the user

        showEntity.getTickets().add(ticketEntity);


        //Add the ticket in the tickets list of the user Entity
        userEntity.getTicketEntities().add(ticketEntity);


        ticketEntity = ticketRepository.save(ticketEntity);

        return TicketConvertor.convertEntityToDto(ticketEntity);


    }
}
