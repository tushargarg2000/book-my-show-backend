package com.example.project.bookmyshowbackend.controller;


import com.example.project.bookmyshowbackend.dto.EntryRequest.MovieEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieNameAndIdObject;
import com.example.project.bookmyshowbackend.dto.ResponseDto.MovieResponseDto;
import com.example.project.bookmyshowbackend.service.impl.MovieServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("movie")
public class MovieController {


    @Autowired
    MovieServiceImpl movieService;


    @PostMapping("/add")
    public MovieResponseDto addMovie(@RequestBody()MovieEntryDto movieEntryDto){

        MovieResponseDto movieResponseDto = movieService.addMovie(movieEntryDto);

        log.info("The movieResponseDto is ",movieResponseDto);
        return movieResponseDto;

    }

    @GetMapping("/get/{id}")
    public MovieNameAndIdObject getNameAndId(@PathVariable Integer id){

        MovieNameAndIdObject movieNameAndIdObject = movieService.getNameAndId(id);

        return movieNameAndIdObject;
    }


}
