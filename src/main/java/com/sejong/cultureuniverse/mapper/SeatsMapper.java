package com.sejong.cultureuniverse.mapper;

import com.sejong.cultureuniverse.dto.performances.SeatsDTO;
import com.sejong.cultureuniverse.entity.reservation.Seats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatsMapper {
    SeatsMapper INSTANCE = Mappers.getMapper(SeatsMapper.class);
    
    
    @Mapping(target = "seatNo", expression = "java(seats.getSeatNo())")
    @Mapping(target = "rowNo", expression = "java(seats.getRowNo())")
    @Mapping(target = "colNo", expression = "java(seats.getColNo())")
    @Mapping(target = "isBooked", expression = "java(seats.getIsBooked())")
    @Mapping(target = "price", expression = "java(seats.getPrice())")
    SeatsDTO seatsToDto(Seats seats);
}
