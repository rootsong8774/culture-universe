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
public class PerformanceListDTO implements Serializable {

    private Long performId;
    
    private String performCode;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String genreName;

    private String fileUrlMi;
}
