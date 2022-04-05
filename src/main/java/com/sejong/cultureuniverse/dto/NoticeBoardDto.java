package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class NoticeBoardDto {

    private Long noticeIdx;

    private Admin adminId;

    private String noticeTitle;
    private String noticeContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

}