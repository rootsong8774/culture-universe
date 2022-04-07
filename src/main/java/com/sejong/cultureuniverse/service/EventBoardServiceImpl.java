package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.EventBoardDto;
import com.sejong.cultureuniverse.dto.NoticeBoardAndAdminDto;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.repository.EventBoardRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
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
    public PageResultDTO<EventBoardDto, Object[]> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("eventIdx").descending());

        //BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<Object[]> result = eventBoardRepository.findAllWithAdminId(pageable);

        Function<Object[], EventBoardDto> fn = (en -> entityToDto(
            EventBoard.builder()
                .eventIdx((Long)en[0])
                .eventTitle((String) en[1])
                .eventContent((String) en[2])
                .readCount((Long) en[3])
                .regDate((LocalDateTime) en[4])
                .modDate((LocalDateTime) en[5])
                .build(),
            Admin.builder()
                .adminId((String) en[6])
                .adminPw((String) en[7])
                .build())
        );
        return new PageResultDTO<>(result, fn);

    }

    @Override
    public EventBoardDto read(Long eventIdx) {
        return eventBoardRepository.findEventBoardByEventIdx(
            eventIdx);
    }
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(EventBoardDto dto) {

        EventBoardDto result = eventBoardRepository.findEventBoardByEventIdx(
            dto.getEventIdx());

        result.changeTitle(dto.getEventTitle());
        result.changeContent(dto.getEventContent());
        EventBoard entity = dtoToEntity(result);

        eventBoardRepository.save(entity);

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

