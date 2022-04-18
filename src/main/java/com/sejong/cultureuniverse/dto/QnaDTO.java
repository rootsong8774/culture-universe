package com.sejong.cultureuniverse.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class QnaDTO {
//    private String username;
    private String type;
    private String title;
    private String content;
}
