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
    private Admin adminId;
    private String winTitle;
    private String winContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

}