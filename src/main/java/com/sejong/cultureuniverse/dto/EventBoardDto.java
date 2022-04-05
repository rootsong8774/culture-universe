package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventBoard;
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
public class EventBoardDto implements Serializable {

    private Long eventIdx;
    private Admin adminId;
    private String eventTitle;
    private String eventContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

    public EventBoard toEntity(){
        return EventBoard.builder()
            .eventIdx(eventIdx)
            .adminId(adminId)
            .eventTitle(eventTitle)
            .eventContent(eventContent)
            .readCount(readCount)
            .build();
    }

}