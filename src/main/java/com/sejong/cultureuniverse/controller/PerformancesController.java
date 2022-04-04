package com.sejong.cultureuniverse.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PerformanceListDto;
import com.sejong.cultureuniverse.service.performances.PerformancesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@Log4j2
@RequestMapping("/api")
@RequiredArgsConstructor
public class PerformancesController {


    @Autowired
    private final PerformancesService performancesService;

    @GetMapping(value="/performancesList")
    public List<PerformanceListDto> list(PageRequestDTO pageRequestDTO) {
        System.out.println(pageRequestDTO.getPage());

        return performancesService.getList(pageRequestDTO).getDtoList();

    }

}
