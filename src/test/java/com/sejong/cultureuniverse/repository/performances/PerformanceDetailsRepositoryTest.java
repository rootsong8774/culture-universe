package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsSearchCondition;
import com.sejong.cultureuniverse.dto.performances.PerformanceListDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class PerformanceDetailsRepositoryTest {
    
    @Autowired
    PerformanceDetailsRepository performanceDetailsRepository;
    
    @Test
    @Transactional(readOnly = true)
    void findAllTest() {
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        Page<PerformanceDetails> result = performanceDetailsRepository.findAll(
            pageRequestDTO.getPageable(Sort.by("performId").ascending()));
        for (PerformanceDetails performanceDetails : result) {
            System.out.println("performanceDetails.getStartDate() = " + performanceDetails.getStartDate());
        }
    }
    
    @Test
    @Transactional(readOnly = true)
    public void querydslTest() {
        PerformanceDetailsSearchCondition searchCondition = new PerformanceDetailsSearchCondition();
        searchCondition.setGenreList(new String[] {"기악"});
        searchCondition.setDateRangeStart("2022-04-22");
        searchCondition.setDateRangeEnd("2022-04-23");
        
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        Pageable pageable = PageRequest.of(0,12, Sort.by("startDate").descending());
    
        Page<PerformanceDetails> page = performanceDetailsRepository.search(searchCondition,pageable
            );
        for (PerformanceDetails performanceListDTO : page) {
            System.out.println(performanceListDTO.getTitle());
            System.out.println(performanceListDTO.getStartDate().toLocalDate());
        }
    }
    
    @Test
    public void findGenreTest() {
        List<String> genreList = performanceDetailsRepository.findAllGenre();
        for (String genre : genreList) {
            System.out.println("genre = " + genre);
        }
    }
    
    @Test
    public void findPlaceTest()  {
        List<String> placeList = performanceDetailsRepository.findAllPlaceName();
        for (String s : placeList) {
            System.out.println("s = " + s);
        }
    
    }
    
    
}