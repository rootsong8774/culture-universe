package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.repository.performances.PerformanceDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class PerformanceFeignServiceImpl implements PerformanceFeignService {

    private final PerformanceDetailsRepository repository;

    @Override
    @Transactional
    public void register(PerformanceDetails details) {
        log.info("dto");

        repository.save(details);
    }
}
