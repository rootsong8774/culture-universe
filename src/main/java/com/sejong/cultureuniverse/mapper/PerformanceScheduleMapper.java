package com.sejong.cultureuniverse.mapper;

import com.sejong.cultureuniverse.dto.performances.PerformanceScheduleDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PerformanceScheduleMapper {
    
    PerformanceScheduleMapper INSTANCE = Mappers.getMapper(PerformanceScheduleMapper.class);
    
    
    @Mapping(target = "performanceDetails.performCode", expression = "java(performanceScheduleDTO.getPerformCode())")
    @Mapping(target = "scheduleCode", expression = "java(performanceScheduleDTO.getScheduleCode())")
    @Mapping(target = "scheduleDate", expression = "java(performanceScheduleDTO.getScheduleDate())")
    @Mapping(target = "scheduleTime", expression = "java(performanceScheduleDTO.getScheduleTime())")
    PerformanceSchedule dtoToSchedule(PerformanceScheduleDTO performanceScheduleDTO);
    
    @Mapping(target = "performCode", expression = "java(performanceSchedule.getPerformanceDetails().getPerformCode())")
    @Mapping(target = "scheduleCode", expression = "java(performanceSchedule.getScheduleCode())")
    @Mapping(target = "scheduleDate", expression = "java(performanceSchedule.getScheduleDate())")
    @Mapping(target = "scheduleTime", expression = "java(performanceSchedule.getScheduleTime())")
    PerformanceScheduleDTO scheduleToDto(PerformanceSchedule performanceSchedule);
}
