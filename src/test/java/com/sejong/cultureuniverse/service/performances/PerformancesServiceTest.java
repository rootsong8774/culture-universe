package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PerformanceDetailsDto;
import com.sejong.cultureuniverse.dto.PerformanceListDto;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PerformancesServiceTest {

    @Autowired
    private PerformancesService performancesService;

    @Test
    void getList() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        List<PerformanceListDto> result = performancesService.getList(pageRequestDTO).getDtoList();

        for (PerformanceListDto performanceListDto : result) {
            System.out.println("performanceListDto = " + performanceListDto);
        }
    }
    
    @Test
    public void performanceDetailsTest() throws Exception {
        PerformanceDetailsDto result = performancesService.getPerformanceDetail(
            "acpm2203141110a01");
        System.out.println("result = " + result);
    }
}