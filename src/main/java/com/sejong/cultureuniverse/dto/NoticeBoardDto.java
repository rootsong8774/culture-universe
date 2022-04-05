package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBoardDto implements Serializable {

    private Long noticeIdx;
    private Admin adminId;
    private String noticeTitle;
    private String noticeContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

    public NoticeBoard toEntity(){
        return NoticeBoard.builder()
            .noticeIdx(noticeIdx)
            .adminId(adminId)
            .noticeTitle(noticeTitle)
            .noticeContent(noticeContent)
            .readCount(readCount)

            .build();
    }

}