package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.TheaterEntity;
import com.example.project.bookmyshowbackend.Model.TheaterSeatsEntity;
import com.example.project.bookmyshowbackend.Repository.TheaterRepository;
import com.example.project.bookmyshowbackend.Repository.TheaterSeatsRepository;
import com.example.project.bookmyshowbackend.converter.TheaterConverter;
import com.example.project.bookmyshowbackend.dto.EntryRequest.TheaterEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.TheaterResponseDto;
import com.example.project.bookmyshowbackend.enums.SeatType;
import com.example.project.bookmyshowbackend.enums.TheaterType;
import com.example.project.bookmyshowbackend.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {

        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);


        //create the Seats
        List<TheaterSeatsEntity> seats = createTheaterSeats();

        theaterEntity.setSeats(seats);
        //I need to set the theaterId for all these seats

        theaterEntity.setShows(null);

        for(TheaterSeatsEntity theaterSeatsEntity:seats){
            theaterSeatsEntity.setTheater(theaterEntity);
        }
        theaterEntity.setType(TheaterType.SINGLE);

        log.info("The thetaer entity is "+ theaterEntity);

        theaterEntity = theaterRepository.save(theaterEntity);

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);


        return theaterResponseDto;

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
    public TheaterResponseDto getTheater(int id) {

        TheaterEntity theaterEntity = theaterRepository.findById(id).get();

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;
    }
}
