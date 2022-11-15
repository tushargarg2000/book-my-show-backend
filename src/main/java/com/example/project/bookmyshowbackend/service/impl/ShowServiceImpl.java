package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.*;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.Repository.ShowRepository;
import com.example.project.bookmyshowbackend.Repository.ShowSeatsRepository;
import com.example.project.bookmyshowbackend.Repository.TheaterRepository;
import com.example.project.bookmyshowbackend.converter.ShowConvertor;
import com.example.project.bookmyshowbackend.dto.ShowDto;
import com.example.project.bookmyshowbackend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowDto addShow(ShowDto showDto) {


        //We have made the partial Show Entity Object..

        //Goal : Set the Movie and the Theater Entities and not the Dto

        ShowEntity showEntity = ShowConvertor.convertDtoToEntity(showDto);

        //MovieEntity

        MovieEntity movieEntity = movieRepository.findById(showDto.getMovieDto().getId()).get();

        TheaterEntity theaterEntity = theaterRepository.findById(showDto.getTheaterDto().getId()).get();


        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theaterEntity);


        //We need to pass the list of the theater seats
        generateShowEntitySeats(theaterEntity.getSeats(),showEntity);

        showEntity = showRepository.save(showEntity);

        return showDto;

    }

    public void generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeatsEntityList,ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();

        //For all the seats in the theater


        for(TheaterSeatsEntity tse : theaterSeatsEntityList){

            //I need to create a ShowSeats Entity save it.
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType())
                    .rate(tse.getRate())
                    .build();

            showSeatsEntityList.add(showSeatsEntity);
        }

        //We need to set the show Entity for each of the ShowSeat....
        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){

            showSeatsEntity.setShow(showEntity);
        }

        showSeatsRepository.saveAll(showSeatsEntityList);

    }

}
