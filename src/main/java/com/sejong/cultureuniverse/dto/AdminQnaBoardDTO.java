package com.sejong.cultureuniverse.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminQnaBoardDTO {
    private Long questionIdx;
    private String title;
    private String type;
    private String content;
    private LocalDateTime regDate, modDate;
}
