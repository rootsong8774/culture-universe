package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.EventBoardDto;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;

import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.repository.EventBoardRepository;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class EventBoardServiceImpl implements EventBoardService {

    private final EventBoardRepository eventBoardRepository;

    @Override
    public Long register(EventBoardDto dto) {
        log.info("DTO---------------------------");
        log.info(dto);
        EventBoard entity = dtoToEntity(dto);

        log.info(entity);

        eventBoardRepository.save(entity);
        return entity.getEventIdx();
    }

    @Override
    public PageResultDTO<EventBoardDto, EventBoard> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("EventIdx").descending());

        //BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<EventBoard> result = eventBoardRepository.findAll(pageable);

        Function<EventBoard, EventBoardDto> fn = (this::entityToDto);
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public EventBoardDto read(Long eventIdx) {
        Optional<EventBoard> result = Optional.ofNullable(
            eventBoardRepository.findByEventIdx(eventIdx));
        return result.map(this::entityToDto).orElse(null);
    }
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(EventBoardDto dto) {
        Optional<EventBoard> result = Optional.ofNullable(
            eventBoardRepository.findByEventIdx(dto.getEventIdx()));
        if (result.isPresent()) {
            EventBoard entity = result.get();

            entity.changeTitle(dto.getEventTitle());
            entity.changeContent(dto.getEventContent());

            eventBoardRepository.save(entity);
        }
    }

    @Override
    public void remove(Long eventIdx) {
        eventBoardRepository.deleteByEventIdx(eventIdx);
    }
   /* private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();
        BooleanBuilder builder = new BooleanBuilder();
        QGuestbook qGuestbook = QGuestbook.guestbook;

        BooleanExpression expression = qGuestbook.gno.gt(0L);

        builder.and(expression);

        if (type == null || type.trim().length() == 0) {
            return builder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if (type.contains("t")) {
            conditionBuilder.or(qGuestbook.title.contains(keyword));
        }

        if (type.contains("c")) {
            conditionBuilder.or(qGuestbook.content.contains(keyword));
        }

        if (type.contains("w")) {
            conditionBuilder.or(qGuestbook.writer.contains(keyword));
        }

        builder.and(conditionBuilder);

        return builder;

    }*/
}

