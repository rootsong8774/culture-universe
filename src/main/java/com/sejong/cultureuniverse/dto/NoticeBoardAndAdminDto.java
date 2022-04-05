package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.admin.Admin;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class NoticeBoardAndAdminDto {
    private Long noticeIdx;

    private String adminId;
    private String adminPw;

    private String noticeTitle;
    private String noticeContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

    public void changeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public void changeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
}
