package com.sejong.cultureuniverse.dto.performances;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PerformanceDetailsDTO implements Serializable {

    private Long performId;
    
    private String performCode;

    private String title;

    private LocalDateTime startDate;
    
    private String dayOfStartDate;

    private LocalDateTime endDate;
    
    private String dayOfEndDate;
    
    private String placeName;
    
    private String playTime;
    
    private String audienceAge;
    
    private String inquiryPhone;
    
    private String ticketInfo;
    
    private String genreName;
    
    private String info;
    
    private String detail;

    private String fileUrlMi;
}
