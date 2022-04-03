package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.dto.PerformanceListDto;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import org.springframework.data.domain.Page;

public interface PerformancesService {

    PageResultDTO<PerformanceListDto, PerformanceDetails> getList(PageRequestDTO pageRequestDTO);

    default PerformanceListDto entityToDTO(PerformanceDetails details) {
        return PerformanceListDto.builder()
            .performId(details.getPerformId())
            .title(details.getTitle())
            .startDate(details.getStartDate())
            .endDate(details.getEndDate())
            .genreName(details.getGenreName())
            .fileUrlMi(details.getFileUrlMi())
            .build();
    }
}
