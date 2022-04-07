package com.sejong.cultureuniverse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PerformanceDetailsFeignDTO implements Serializable {

    @JsonProperty("PERFORM_CODE")
    private String performCode;

    @JsonProperty("TITLE")
    private String title;

    @JsonProperty("START_DATE")
    private String startDate;

    @JsonProperty("END_DATE")
    private String endDate;

    @JsonProperty("PLACE_NAME")
    private String placeName;

    @JsonProperty("PLAY_TIME")
    private String playTime;

    @JsonProperty("AGE")
    private String age;

    @JsonProperty("PLAN_COMPANY")
    private String planCompany;

    @JsonProperty("INQUIRY_PHONE")
    private String inquiryPhone;

    @JsonProperty("INQUIRY_EMAIL")
    private String inquiryEmail;

    @JsonProperty("TICKET_INFO")
    private String ticketInfo;

    @JsonProperty("GENRE_NAME")
    private String genre;

    @JsonProperty("ISOPEN")
    private String isopen;

    @JsonProperty("ISOPENNM")
    private String isopennm;

    @JsonProperty("FILE_URL_MI")
    private String fileUrlMi;

    @JsonProperty("FILE_URL_TI")
    private String fileUrlTi;

    @JsonProperty("INFO")
    private String info;

    @JsonProperty("DETAIL")
    private String detail;

    @JsonProperty("CAST_INFO")
    private String castInfo;




}
