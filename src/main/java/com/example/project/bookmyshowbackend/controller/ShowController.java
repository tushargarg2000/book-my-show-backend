package com.example.project.bookmyshowbackend.controller;


import com.example.project.bookmyshowbackend.dto.EntryRequest.ShowEntryDto;
import com.example.project.bookmyshowbackend.dto.ResponseDto.ShowResponseDto;
import com.example.project.bookmyshowbackend.service.impl.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {


    @Autowired
    ShowServiceImpl showService;


    @PostMapping("add")
    public ShowResponseDto addShow(@RequestBody()ShowEntryDto showEntryDto){

        return showService.addShow(showEntryDto);
    }


}
