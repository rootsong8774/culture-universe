package com.sejong.cultureuniverse.mapper;

import com.sejong.cultureuniverse.dto.performances.PerformanceScheduleDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PerformanceScheduleMapper {
    PerformanceScheduleMapper INSTANCE = Mappers.getMapper(PerformanceScheduleMapper.class);
    
    @Mapping(target = "performanceDetails.performId", expression = "java(performanceScheduleDTO.getPerformId())")
    @Mapping(target = "scheduleDate", expression = "java(performanceScheduleDTO.scheduleDate")
    @Mapping(target = "scheduleTime", expression = "java(performanceScheduleDTO.scheduleTime")
    PerformanceSchedule dtoToSchedule(PerformanceScheduleDTO performanceScheduleDTO);
    
    
    @Mapping(target = "performId", expression = "java(performanceSchedule.getPerformanceDetails().getPerformId())")
    @Mapping(target ="scheduleDate", expression = "java(performanceSchedule.getScheduleDate())")
    @Mapping(target ="scheduleTime", expression = "java(performanceSchedule.getScheduleTime())")
    PerformanceScheduleDTO scheduleToDto(PerformanceSchedule performanceSchedule);
}
