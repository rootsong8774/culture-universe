package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.event.EventComment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentResponseDto {
    private Long id;
    private String comment;
    private String nickname;
    private Long boardId;

    /*entitiy -> dto*/
    public CommentResponseDto(EventComment comment){
        this.id = comment.getCommentIdx();
        this.comment = comment.getEventComment();
        this.nickname = comment.getMember().getName();
        this.boardId = comment.getEventBoard().getEventIdx();
    }

}
