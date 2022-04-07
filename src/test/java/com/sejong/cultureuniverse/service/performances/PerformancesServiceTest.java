package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PerformanceDetailsDTO;
import com.sejong.cultureuniverse.dto.PerformanceListDTO;
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
        List<PerformanceListDTO> result = performancesService.getList(pageRequestDTO).getDtoList();

        for (PerformanceListDTO performanceListDto : result) {
            System.out.println("performanceListDto = " + performanceListDto);
        }
    }
    
    @Test
    public void performanceDetailsTest() throws Exception {
        PerformanceDetailsDTO result = performancesService.getPerformanceDetail(
            "acpm2203141110a01");
        System.out.println("result = " + result);
    }
}