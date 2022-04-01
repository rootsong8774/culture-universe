package com.sejong.cultureuniverse.entity.performance;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "performance_seq", sequenceName = "performance_seq", initialValue = 1, allocationSize = 1)
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

    private Integer age;

    private String planCompany;

    private String inquiryPhone;
    private String inquiryEmail;

    private String ticketInfo;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String isopen;
    private String isopennm;

    private String fileUrlMi;
    private String fileUrlTi;

    private String info;
    private String detail;
    private String castInfo;
}
