package com.sejong.cultureuniverse.repository;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceDetailsRepository extends JpaRepository<PerformanceDetails, Long> {

    Page<PerformanceDetails> findAll(Pageable pageable);
    
    Optional<PerformanceDetails> findByPerformCode(String performCode);
    
    PerformanceDetails findByPerformId(Long id);
}
