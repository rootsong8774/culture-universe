package com.sejong.cultureuniverse.dto.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class NoticeBoardDTO {
    private Long noticeIdx;

    private Admin admin;

    private String noticeTitle;
    private String noticeContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

    
}
