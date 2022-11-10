package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.TheaterEntity;
import com.example.project.bookmyshowbackend.Model.TheaterSeatsEntity;
import com.example.project.bookmyshowbackend.Repository.TheaterRepository;
import com.example.project.bookmyshowbackend.Repository.TheaterSeatsRepository;
import com.example.project.bookmyshowbackend.converter.TheaterConverter;
import com.example.project.bookmyshowbackend.dto.TheaterDto;
import com.example.project.bookmyshowbackend.enums.SeatType;
import com.example.project.bookmyshowbackend.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    @Override
    public TheaterDto addTheater(TheaterDto theaterDto) {

        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterDto);


        //create the Seats
        List<TheaterSeatsEntity> seats = createTheaterSeats();

        //I need to set the theaterId for all these seats

        for(TheaterSeatsEntity theaterSeatsEntity:seats){
            theaterSeatsEntity.setTheater(theaterEntity);
        }

        theaterEntity = theaterRepository.save(theaterEntity);

        return theaterDto;

    }

    List<TheaterSeatsEntity> createTheaterSeats(){


        List<TheaterSeatsEntity> seats = new ArrayList<>();

        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",100,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",100,SeatType.PREMIUM));


        theaterSeatsRepository.saveAll(seats);

        return seats;
        //Add in this TheaterSeatEntity type

    }

    TheaterSeatsEntity getTheaterSeat(String seatName, int rate, SeatType seatType){

        return TheaterSeatsEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }

    //Seperate function will be create...


    @Override
    public TheaterDto getTheater(int id) {

        TheaterEntity theaterEntity = theaterRepository.findById(id).get();

        TheaterDto theaterDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterDto;
    }
}
