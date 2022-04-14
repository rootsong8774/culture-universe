package com.sejong.cultureuniverse.dto;


import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.EventComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private Long id;
    private String comment;
    private Member member;
    private EventBoard eventBoard;

    //dto-entity
    public EventComment toEntity() {
        EventComment comments = EventComment.builder()
            .commentIdx(getId())
            .eventComment(getComment())
            .member(getMember())
            .eventBoard(getEventBoard())
            .build();
        return comments;
    }


}
