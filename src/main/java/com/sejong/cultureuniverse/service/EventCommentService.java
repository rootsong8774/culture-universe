package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.EventCommentDto;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.event.EventComment;
import com.sejong.cultureuniverse.repository.EventCommentRepository;
import java.util.List;

public interface EventCommentService {

    Long register(EventCommentDto commentDto);
    List<EventComment> getList(Long commentIdx);
    void delete(Long commentIdx);


    default EventCommentDto entityToDto(EventComment eventComment){
        return EventCommentDto.builder()
            .commentIdx(eventComment.getCommentIdx())
            .eventComment(eventComment.getEventComment())
            .modDate(eventComment.getModDate())
            .build();
    }
}
