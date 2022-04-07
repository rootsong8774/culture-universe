package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.admin.Admin;

import com.sejong.cultureuniverse.entity.event.EventWinner;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WinnerBoardDto {

    private Long winnerIdx;

    private String adminId;
    private String adminPw;

    private String winTitle;
    private String winContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

    public void changeTitle(String winTitle) {
        this.winTitle = winTitle;
    }

    public void changeContent(String winContent) {
        this.winContent = winContent;
    }
}