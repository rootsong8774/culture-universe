package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.dto.PerformanceDetailsDto;
import com.sejong.cultureuniverse.dto.PerformanceListDto;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;

public interface PerformancesService {

    PageResultDTO<PerformanceListDto, PerformanceDetails> getList(PageRequestDTO pageRequestDTO);
    
    PerformanceDetailsDto getPerformanceDetail(String performCode);

    default PerformanceListDto entityToListDTO(PerformanceDetails details) {
        return PerformanceListDto.builder()
            .performId(details.getPerformId())
            .performCode(details.getPerformCode())
            .title(details.getTitle())
            .startDate(details.getStartDate())
            .endDate(details.getEndDate())
            .genreName(details.getGenreName())
            .fileUrlMi(details.getFileUrlMi())
            .build();
    }
    
    default PerformanceDetailsDto entityToDetailsDTO(PerformanceDetails details) {
        return PerformanceDetailsDto.builder()
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
            .detail(details.getDetail())
            .fileUrlMi(details.getFileUrlMi())
            .build();
    }
}
