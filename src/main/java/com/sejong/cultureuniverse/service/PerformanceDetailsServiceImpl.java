package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.repository.PerformanceDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PerformanceDetailsServiceImpl implements PerformanceDetailsService{

    private final PerformanceDetailsRepository repository;

    @Override
    public void register(PerformanceDetails details) {
        log.info("dto");

        repository.save(details);
    }
}
