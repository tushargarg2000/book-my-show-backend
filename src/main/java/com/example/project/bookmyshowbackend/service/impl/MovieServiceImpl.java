package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.MovieEntity;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.converter.MovieConverter;
import com.example.project.bookmyshowbackend.dto.MovieDto;
import com.example.project.bookmyshowbackend.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;


@Slf4j

public class MovieServiceImpl implements MovieService {


    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieDto addMovie(MovieDto movieDto) {

        //if the movie is already created then we can throw an exception....movie already exists.



        if(movieDto.getId()<0){
            throw new EntityNotFoundException("Movie can't be found");
        }

        log.info("Adding the movie",movieDto);


        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieDto);
        movieEntity = movieRepository.save(movieEntity);

        return movieDto;

    }

    @Override
    public MovieDto getMovie(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieDto movieDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieDto;

    }
}
