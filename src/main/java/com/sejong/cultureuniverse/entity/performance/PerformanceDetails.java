package com.sejong.cultureuniverse.entity.performance;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "performance_seq", sequenceName = "performance_seq", initialValue = 1, allocationSize = 1)
@ToString
public class PerformanceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "performance_seq")
    private Long performId;
    private String performCode;
    private String title;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private String placeName;
    private String playTime;

    private String age;

    private String planCompany;

    private String inquiryPhone;
    private String inquiryEmail;

    private String ticketInfo;

    private String genreName;

    private String isopen;
    private String isopennm;

    private String fileUrlMi;
    private String fileUrlTi;

    @Lob
    private String info;
    @Lob
    private String detail;
    @Lob
    private String castInfo;

}
