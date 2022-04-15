package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsSearchCondition;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PerformanceDetailsRepositoryCustom {
    
    Page<PerformanceDetails> search(PerformanceDetailsSearchCondition condition, Pageable pageable);
}
