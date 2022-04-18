package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.admin.AdminComment;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class QnaBoardDTO {
    private Long questionIdx;
    private Long userIdx;
    private String content;
    private String title;
    private String type;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int commentCount;
}

