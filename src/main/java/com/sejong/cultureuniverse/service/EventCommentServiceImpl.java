package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.EventCommentDto;
import com.sejong.cultureuniverse.entity.event.EventComment;
import com.sejong.cultureuniverse.repository.EventCommentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventCommentServiceImpl implements EventCommentService {
    private final EventCommentRepository eventCommentRepository;

    @Override
    public Long register(EventCommentDto commentDto){
        EventComment eventComment = this.dtoToEntity(commentDto);
        eventCommentRepository.save(eventComment);
        return eventComment.getCommentIdx();
    }
    @Override
    public List<EventComment> getList(Long eventIdx) {
        return EventCommentRepository.getCommentOrderByEventIdx(eventIdx);
//            result.stream().map(this::entityToDto)
//            .collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long commentIdx) {
        eventCommentRepository.deleteById(commentIdx);
    }
}
