package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceListDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.time.format.TextStyle;
import java.util.Locale;

public interface PerformancesService {

    PageResultDTO<PerformanceListDTO, PerformanceDetails> getList(PageRequestDTO pageRequestDTO);
    
    PerformanceDetailsDTO getPerformanceDetail(String performCode);

    default PerformanceListDTO entityToListDTO(PerformanceDetails details) {
        return PerformanceListDTO.builder()
            .performId(details.getPerformId())
            .performCode(details.getPerformCode())
            .title(details.getTitle())
            .startDate(details.getStartDate())
            .endDate(details.getEndDate())
            .genreName(details.getGenreName())
            .fileUrlMi(details.getFileUrlMi())
            .build();
    }
    
    default PerformanceDetailsDTO entityToDetailsDTO(PerformanceDetails details) {
        return PerformanceDetailsDTO.builder()
            .performId(details.getPerformId())
            .performCode(details.getPerformCode())
            .title(details.getTitle())
            .startDate(details.getStartDate())
            .dayOfStartDate(details.getStartDate().getDayOfWeek().getDisplayName(TextStyle.SHORT,
                Locale.KOREAN))
            .endDate(details.getEndDate())
            .dayOfEndDate(details.getEndDate().getDayOfWeek().getDisplayName(TextStyle.SHORT,
                Locale.KOREAN))
            .placeName(details.getPlaceName())
            .playTime(details.getPlayTime())
            .audienceAge(details.getAge())
            .inquiryPhone(details.getInquiryPhone())
            .ticketInfo(details.getTicketInfo())
            .genreName(details.getGenreName())
            .info(details.getInfo())
            .detail(details.getDetail())
            .fileUrlMi(details.getFileUrlMi())
            .build();
    }
}
