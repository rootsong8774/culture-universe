package com.sejong.cultureuniverse.dto.admin;

import java.time.LocalDateTime;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class EventBoardDTO {
    private Long eventIdx;

    private String adminId;
    private String adminPw;
    private String eventTitle;
    private String eventContent;
    private Long readCount;
    private LocalDateTime regDate, modDate;

    public void changeTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void changeContent(String eventContent) {
        this.eventContent = eventContent;
    }
}