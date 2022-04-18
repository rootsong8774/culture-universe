package com.sejong.cultureuniverse.dto.admin;

import com.sejong.cultureuniverse.entity.admin.Admin;
import java.time.LocalDateTime;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WinnerBoardDTO {

    private Long winnerIdx;

    private Admin admin;

    private String winTitle;
    private String winContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

   
}