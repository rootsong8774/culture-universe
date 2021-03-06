package com.sejong.cultureuniverse.restController.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sejong.cultureuniverse.dto.ReservationRepositoryListDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.performances.ReservationDTO;
import com.sejong.cultureuniverse.service.performances.PerformancesService;
import com.sejong.cultureuniverse.service.reservation.ReservationService;
import com.sejong.cultureuniverse.service.reservation.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    
    private final ScheduleService scheduleService;
    private final ReservationService reservationService;
    private final PerformancesService performancesService;
    
    
    @GetMapping("/performancesDetails")
    public String performancesDetails(@ModelAttribute("performCode") String performCode, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO)
        throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new JavaTimeModule()).writeValueAsString(performancesService.getPerformanceDetail(
            performCode));
    }
    
    @GetMapping(value = "/schedule")
    public String getSchedule(String performCode, PageRequestDTO pageRequestDTO)
        throws JsonProcessingException {
        
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(scheduleService.getScheduleList(performCode, pageRequestDTO));
    }
    
    @GetMapping(value = "/seats")
    public String getSeatsList(Long scheduleCode) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(reservationService.getSeatsList(scheduleCode));
    }
    
    @PostMapping(value = "/reservation")
    public void reservation(@RequestBody ReservationDTO dto) {
        System.out.println(dto.getUsername()+"," + dto.getSeatNos()[0]);
        reservationService.reservation(dto.getUsername(), dto.getSeatNos());
    }

    @GetMapping(value = "/reservationlist")
    public String getReservationList(Long reservationId) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(reservationService.getReservation(reservationId));
    }
    @PostMapping(value = "/delete")
    public void delete(@RequestBody ReservationRepositoryListDTO dto) {
        reservationService.cancelReservation(dto.getReservationId());
    }
}
