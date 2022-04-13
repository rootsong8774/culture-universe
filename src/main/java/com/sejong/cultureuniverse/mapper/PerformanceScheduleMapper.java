package com.sejong.cultureuniverse.mapper;

import com.sejong.cultureuniverse.dto.performances.PerformanceScheduleDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import com.sejong.cultureuniverse.repository.reservation.SeatsRepository;
import java.time.format.TextStyle;
import java.util.Locale;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {Locale.class,TextStyle.class})
public interface PerformanceScheduleMapper {
    
    PerformanceScheduleMapper INSTANCE = Mappers.getMapper(PerformanceScheduleMapper.class);
    
    
    @Mapping(target = "performanceDetails.performCode", expression = "java(performanceScheduleDTO.getPerformCode())")
    @Mapping(target = "scheduleCode", expression = "java(performanceScheduleDTO.getScheduleCode())")
    @Mapping(target = "scheduleDate", expression = "java(performanceScheduleDTO.getScheduleDate())")
    @Mapping(target = "scheduleTime", expression = "java(performanceScheduleDTO.getScheduleTime())")
    PerformanceSchedule dtoToSchedule(PerformanceScheduleDTO performanceScheduleDTO);
    
    @Mapping(target = "countSeats", expression = "java(INSTANCE.countSeats(performanceSchedule, seatsRepository))")
    @Mapping(target = "dayOfWeek", expression = "java(INSTANCE.dayOfWeek(performanceSchedule))")
    @Mapping(target = "performCode", expression = "java(performanceSchedule.getPerformanceDetails().getPerformCode())")
    @Mapping(target = "scheduleCode", expression = "java(performanceSchedule.getScheduleCode())")
    @Mapping(target = "scheduleDate", expression = "java(performanceSchedule.getScheduleDate())")
    @Mapping(target = "scheduleTime", expression = "java(performanceSchedule.getScheduleTime())")
    PerformanceScheduleDTO scheduleToDto(PerformanceSchedule performanceSchedule, SeatsRepository seatsRepository);
    
    @AfterMapping
    default String dayOfWeek(PerformanceSchedule performanceSchedule) {
        return performanceSchedule.getScheduleDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
        
    }
    
    @AfterMapping
    default Integer countSeats(PerformanceSchedule performanceSchedule,
        @Context SeatsRepository repository) {
        return repository.getCountByScheduleCode(performanceSchedule.getScheduleCode());
    }
}
