package com.sejong.cultureuniverse.service.performances;

import com.sejong.cultureuniverse.dto.PerformanceDetailsFeignDTO;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface PerformanceFeignService {

    void register(PerformanceDetails details);

    default PerformanceDetails dtoToEntity(PerformanceDetailsFeignDTO dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return PerformanceDetails.builder()
            .performCode(dto.getPerformCode())
            .title(dto.getTitle())
            .startDate(LocalDate.parse(dto.getStartDate(),formatter).atStartOfDay())
            .endDate(LocalDate.parse(dto.getEndDate(),formatter).atStartOfDay())
            .placeName(dto.getPlaceName())
            .playTime(dto.getPlayTime())
            .age(dto.getAge())
            .planCompany(dto.getPlanCompany())
            .inquiryPhone(dto.getInquiryPhone())
            .inquiryEmail(dto.getInquiryEmail())
            .ticketInfo(dto.getTicketInfo())
            .genreName(dto.getGenre())
            .isopen(dto.getIsopen())
            .isopennm(dto.getIsopennm())
            .fileUrlMi(dto.getFileUrlMi())
            .fileUrlTi(dto.getFileUrlTi())
            .info(dto.getInfo())
            .detail(dto.getDetail())
            .castInfo(dto.getCastInfo())
            .build();
    }




}
