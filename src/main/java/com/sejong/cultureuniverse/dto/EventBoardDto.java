package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventBoardDto {

    private Long eventIdx;
    private Admin adminId;
    private String eventTitle;
    private String eventContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

}