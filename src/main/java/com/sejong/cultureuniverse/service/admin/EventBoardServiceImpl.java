package com.sejong.cultureuniverse.service.admin;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.sejong.cultureuniverse.dto.admin.EventBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.entity.event.QEventBoard;
import com.sejong.cultureuniverse.repository.EventBoardRepository;
import java.time.LocalDateTime;
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
    public Long register(EventBoardDTO dto) {
        log.info("DTO---------------------------");
        log.info(dto);
        EventBoard entity = dtoToEntity(dto);

        log.info(entity);

        eventBoardRepository.save(entity);
        return entity.getEventIdx();
    }

    @Override
    public PageResultDTO<EventBoardDTO, Object[]> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("eventIdx").descending());

        BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<Object[]> result = eventBoardRepository.findAllWithAdminId(pageable);

        Function<Object[], EventBoardDTO> fn = (en -> entityToDto(
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
    public EventBoardDTO read(Long eventIdx) {
        return eventBoardRepository.findEventBoardByEventIdx(
            eventIdx);
    }
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(EventBoardDTO dto) {

        EventBoardDTO result = eventBoardRepository.findEventBoardByEventIdx(
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

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();
        BooleanBuilder builder = new BooleanBuilder();
        QEventBoard qEventBoard = QEventBoard.eventBoard;

        BooleanExpression expression = qEventBoard.eventIdx.gt(0L);

        builder.and(expression);

        if (type == null || type.trim().length() == 0) {
            return builder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if (type.contains("t")) {
            conditionBuilder.or(qEventBoard.eventTitle.contains(keyword));
        }

        if (type.contains("c")) {
            conditionBuilder.or(qEventBoard.eventContent.contains(keyword));
        }

       /* if (type.contains("w")) {
            conditionBuilder.or(qGuestbook.writer.contains(keyword));
        }*/

        builder.and(conditionBuilder);

        return builder;

    }
}

