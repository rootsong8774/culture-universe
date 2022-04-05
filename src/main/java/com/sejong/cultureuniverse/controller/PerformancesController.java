package com.sejong.cultureuniverse.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PerformanceListDto;
import com.sejong.cultureuniverse.service.performances.PerformancesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class PerformancesController {
    
    private final PerformancesService performancesService;
    
    @GetMapping(value = "/performancesList")
    public String list(PageRequestDTO pageRequestDTO)
        throws JsonProcessingException {
        System.out.println(pageRequestDTO.getPage());
    
        ObjectMapper mapper = new ObjectMapper();
    
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(performancesService.getList(pageRequestDTO));
        
    }
    
}
