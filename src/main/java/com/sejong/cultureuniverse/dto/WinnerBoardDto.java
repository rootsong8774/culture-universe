package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.admin.Admin;

import com.sejong.cultureuniverse.entity.event.EventWinner;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WinnerBoardDto implements Serializable {

    private Long winnerIdx;
    private Admin adminId;
    private String winTitle;
    private String winContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

    public EventWinner toEntity(){
        return EventWinner.builder()
            .winnerIdx(winnerIdx)
            .adminId(adminId)
            .winTitle(winTitle)
            .winContent(winContent)
            .readCount(readCount)
            .build();
    }

}