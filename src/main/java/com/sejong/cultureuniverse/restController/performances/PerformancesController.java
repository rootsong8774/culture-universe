package com.sejong.cultureuniverse.restController.performances;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsSearchCondition;
import com.sejong.cultureuniverse.service.performances.PerformancesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class PerformancesController {
    
    private final PerformancesService performancesService;
    
    
    @GetMapping(value = "/performancesList")
    public String performancesSearch(PageRequestDTO pageRequestDTO, PerformanceDetailsSearchCondition condition)
        throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(performancesService.getSearch(pageRequestDTO, condition));
        
    }
    
    @GetMapping("/performancesDetails")
    public String performancesDetails(@ModelAttribute("performCode") String performCode, @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO)
        throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new JavaTimeModule()).writeValueAsString(performancesService.getPerformanceDetail(
            performCode));
    }
}
