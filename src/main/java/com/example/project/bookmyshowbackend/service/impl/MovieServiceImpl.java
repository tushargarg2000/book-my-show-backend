package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.MovieEntity;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.converter.MovieConverter;
import com.example.project.bookmyshowbackend.dto.EntryRequest.MovieEntryDto;
import com.example.project.bookmyshowbackend.dto.MovieDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import com.example.project.bookmyshowbackend.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;


@Slf4j

public class MovieServiceImpl implements MovieService {


    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {

        //if the movie is already created then we can throw an exception....movie already exists.

        //


        log.info("Adding the movie",movieEntryDto);


        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);
        movieEntity = movieRepository.save(movieEntity);

        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);

        return movieResponseDto; //It can be a response type of the movie

    }

    @Override
    public MovieResponseDto getMovie(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;

    }
}
