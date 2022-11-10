package com.example.project.bookmyshowbackend.service;

import com.example.project.bookmyshowbackend.dto.MovieDto;

public interface MovieService {

    //Add movie

    MovieDto addMovie(MovieDto movieDto);


    //get movie
    MovieDto getMovie(int id);


}
