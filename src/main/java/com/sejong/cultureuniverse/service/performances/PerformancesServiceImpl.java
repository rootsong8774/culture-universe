package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsSearchCondition;
import com.sejong.cultureuniverse.dto.performances.PerformanceListDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.repository.performances.PerformanceDetailsRepository;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PerformancesServiceImpl implements PerformancesService {
    
    private final PerformanceDetailsRepository performanceDetailsRepository;

    @Override
    public PageResultDTO<PerformanceListDTO, PerformanceDetails> getList(PageRequestDTO pageRequestDTO) {
    
        Function<PerformanceDetails, PerformanceListDTO> fn = convertFromDetailsToDTO();
    
        Page<PerformanceDetails> result = performanceDetailsRepository.findAll(
            pageRequestDTO.getPageable(Sort.by("performId").ascending()));

        return new PageResultDTO<>(result,fn);
    }
    
    
    @Override
    public PageResultDTO<PerformanceListDTO, PerformanceDetails> getSearch(
        
        PageRequestDTO pageRequestDTO, PerformanceDetailsSearchCondition condition) {
    
        Function<PerformanceDetails, PerformanceListDTO> fn = convertFromDetailsToDTO();
        Page<PerformanceDetails> result = performanceDetailsRepository.search(condition,
            pageRequestDTO.getPageable(Sort.by("startDate").ascending()));
        return  new PageResultDTO<>(result,fn);
    }
    
    @Override
    public PerformanceDetailsDTO getPerformanceDetail(String performCode) {
        Optional<PerformanceDetails> result = performanceDetailsRepository.findByPerformCode(
            performCode);
       
        return result.map(this::entityToDetailsDTO).orElse(null);
    }
    
    private Function<PerformanceDetails, PerformanceListDTO> convertFromDetailsToDTO() {
        
        return (en-> entityToListDTO(
            PerformanceDetails.builder()
                .performId(en.getPerformId())
                .performCode(en.getPerformCode())
                .title(en.getTitle())
                .startDate(en.getStartDate())
                .endDate(en.getEndDate())
                .placeName(en.getPlaceName())
                .genreName(en.getGenreName())
                .fileUrlMi(en.getFileUrlMi())
                .build()
        ));
    }
    
}
