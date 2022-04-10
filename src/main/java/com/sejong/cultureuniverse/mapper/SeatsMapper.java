package com.sejong.cultureuniverse.mapper;

import com.sejong.cultureuniverse.dto.performances.SeatsDTO;
import com.sejong.cultureuniverse.entity.performance.Seats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatsMapper {
    /*SeatsMapper INSTANCE = Mappers.getMapper(SeatsMapper.class);
    
    @Mapping(target = "seatNo", expression = "java(seatsDTO.getSeatNo())")
    @Mapping(target = "schedule.scheduleDate", expression = "java(seatsDTO.getScheduleDate())")
    @Mapping(target = "schedule.scheduleCode", expression = "java(seatsDTO.getScheduleCode())")
    @Mapping(target = "schedule.scheduleTime", expression = "java(seatsDTO.getScheduleTime())")
    @Mapping(target = "rowNo", expression = "java(seatsDTO.getRowNo())")
    @Mapping(target = "colNo", expression = "java(seatsDTO.getColNo())")
    @Mapping(target = "isBooked", expression = "java(seatsDTO.getIsBooked())")
    @Mapping(target = "price", expression = "java(seatsDTO.getPrice())")
    Seats dtoToSeats(SeatsDTO seatsDTO);
    
    @Mapping(target = "seatNo", expression = "java(seats.getSeatNo())")
    @Mapping(target = "scheduleCode", expression = "java(seats.getSchedule().getScheduleCode())")
    @Mapping(target = "scheduleDate", expression = "java(seats.getSchedule().getScheduleDate())")
    @Mapping(target = "scheduleTime", expression = "java(seats.getSchedule().getScheduleTime())")
    @Mapping(target = "rowNo", expression = "java(seats.getRowNo())")
    @Mapping(target = "colNo", expression = "java(seats.getColNo())")
    @Mapping(target = "isBooked", expression = "java(seats.getIsBooked())")
    @Mapping(target = "price", expression = "java(seats.getPrice())")
    SeatsDTO seatsToDto(Seats seats);*/
}
