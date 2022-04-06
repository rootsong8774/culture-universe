package com.sejong.cultureuniverse.dto;

import lombok.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminCommentDTO {
    private Long commentIdx;
    private String commentContent;
    private LocalDateTime regDate, modDate;
    private String adminId; //기준으로 삭제돼야함


}
