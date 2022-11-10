package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.MovieEntity;
import com.example.project.bookmyshowbackend.dto.MovieDto;

public class MovieConverter {


    public static MovieEntity convertDtoToEntity(MovieDto movieDto){

        return MovieEntity.builder().id(movieDto.getId()).name(movieDto.getName())
                .releaseDate(movieDto.getReleaseDate()).build();

    }

    public static MovieDto convertEntityToDto(MovieEntity movieEntity){

        return MovieDto.builder().id(movieEntity.getId()).releaseDate(movieEntity.getReleaseDate()).name(movieEntity.getName()).build()
                ;
    }

}
