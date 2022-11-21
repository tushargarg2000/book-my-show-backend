package com.example.project.bookmyshowbackend.service.impl;

import com.example.project.bookmyshowbackend.Model.MovieEntity;
import com.example.project.bookmyshowbackend.Repository.MovieRepository;
import com.example.project.bookmyshowbackend.converter.MovieConverter;
import com.example.project.bookmyshowbackend.dto.EntryRequest.MovieEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieNameAndIdObject;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import com.example.project.bookmyshowbackend.exception.DuplicateEntityException;
import com.example.project.bookmyshowbackend.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto)  {
    

        //Id --> not there
        //name  --> Yes
        //releaseDate --> Yes


        MovieResponseDto movieResponseDto = null;

        //if the movie is already created then we can throw an exception....movie already exists.
        if(movieRepository.existsByName(movieEntryDto.getName())){
            
            movieResponseDto.setName("This movie is already Existing");
            return movieResponseDto;
        }

        log.info("In the function add movie "+ movieEntryDto);


        //I need a movieEntity Object
        /*
                How can I get it
         */

        //We were createing a MovieEntity Object


        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);


        movieEntity = movieRepository.save(movieEntity); //This will auto add the id variable
        //

         movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);

        return movieResponseDto; //It can be a response type of the movie

    }

    @Override
    public MovieResponseDto getMovie(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;

    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id){

        //I need information from repo
        MovieEntity movieEntity = movieRepository.findById(id).get(); //Get this movieEntity from the database


        //I have to convert it

        MovieNameAndIdObject obj = MovieConverter.convertEntityToThisObject(movieEntity);


        return obj;
    }

}
