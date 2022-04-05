package com.sejong.cultureuniverse.dto;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
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
public class PerformanceDetailsDto implements Serializable {

    private Long performId;
    
    private String performCode;

    private String title;

    private LocalDateTime startDate;
    
    private String dayOfStartDate;

    private LocalDateTime endDate;
    
    private String dayOfEndDate;
    
    private String placeName;
    
    private String age;
    
    private String inquiryPhone;
    
    private String ticketInfo;
    
    private String genreName;

    private String fileUrlMi;
}
