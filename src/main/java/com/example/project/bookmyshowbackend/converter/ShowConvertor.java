package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.ShowEntity;
import com.example.project.bookmyshowbackend.dto.ShowDto;

public class ShowConvertor {


    public static ShowEntity convertDtoToEntity(ShowDto showDto){

        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime())
                .build();
    }
}
