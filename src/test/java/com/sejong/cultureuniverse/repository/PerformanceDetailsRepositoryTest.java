package com.sejong.cultureuniverse.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
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
}