package com.sejong.cultureuniverse.repository.performances;

import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PerformanceDetailsRepository extends JpaRepository<PerformanceDetails, Long>, PerformanceDetailsRepositoryCustom {

    Page<PerformanceDetails> findAll(Pageable pageable);
    
    Optional<PerformanceDetails> findByPerformCode(String performCode);
    
    PerformanceDetails findByPerformId(Long id);
    
    @Query("select distinct p.genreName from PerformanceDetails p")
    List<String> findAllGenre();
    
    @Query("select distinct p.placeName from PerformanceDetails p")
    List<String> findAllPlaceName();
}
