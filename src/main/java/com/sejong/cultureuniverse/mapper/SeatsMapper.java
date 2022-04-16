package com.sejong.cultureuniverse.mapper;

import com.sejong.cultureuniverse.dto.performances.SeatsDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.entity.reservation.Seats;
import java.time.format.TextStyle;
import java.util.Locale;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {Locale.class, TextStyle.class})
public interface SeatsMapper {
    SeatsMapper INSTANCE = Mappers.getMapper(SeatsMapper.class);
    
    @Mapping(target = "dayOfWeek", expression = "java(INSTANCE.dayOfWeek(seats.getSchedule()))")
    @Mapping(target = "scheduleDate", expression = "java(seats.getSchedule().getScheduleDate())")
    @Mapping(target = "scheduleTime", expression = "java(seats.getSchedule().getScheduleTime())")
    @Mapping(target = "seatNo", expression = "java(seats.getSeatNo())")
    @Mapping(target = "rowNo", expression = "java(seats.getRowNo())")
    @Mapping(target = "colNo", expression = "java(seats.getColNo())")
    @Mapping(target = "isBooked", expression = "java(seats.getIsBooked())")
    @Mapping(target = "price", expression = "java(seats.getPrice())")
    SeatsDTO seatsToDto(Seats seats);
    
    @AfterMapping
    default String dayOfWeek(PerformanceSchedule performanceSchedule) {
        return performanceSchedule.getScheduleDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
        
    }
}
