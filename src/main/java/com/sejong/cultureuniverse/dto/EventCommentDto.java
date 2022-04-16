package com.sejong.cultureuniverse.dto;


import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventCommentDto {
    private Long commentIdx;
    private String eventComment;

    private Long username;

    private String eventContent;
    private LocalDateTime modDate;


}
