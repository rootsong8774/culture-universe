package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.dto.PerformanceDetailsDTO;
import com.sejong.cultureuniverse.dto.PerformanceListDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import com.sejong.cultureuniverse.repository.PerformanceDetailsRepository;
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

        Function<PerformanceDetails, PerformanceListDTO> fn = (en-> entityToListDTO(
            PerformanceDetails.builder()
                .performId(en.getPerformId())
                .performCode(en.getPerformCode())
                .title(en.getTitle())
                .startDate(en.getStartDate())
                .endDate(en.getEndDate())
                .genreName(en.getGenreName())
                .fileUrlMi(en.getFileUrlMi())
                .build()
        ));

        Page<PerformanceDetails> result = performanceDetailsRepository.findAll(
            pageRequestDTO.getPageable(Sort.by("performId").ascending()));

        return new PageResultDTO<>(result,fn);
    }
    
    @Override
    public PerformanceDetailsDTO getPerformanceDetail(String performCode) {
        Optional<PerformanceDetails> result = performanceDetailsRepository.findByPerformCode(
            performCode);
       
        return result.map(this::entityToDetailsDTO).orElse(null);
    }
    
}
