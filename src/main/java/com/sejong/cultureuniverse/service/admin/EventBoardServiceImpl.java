package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.SessionConst;
import com.sejong.cultureuniverse.dto.admin.EventBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventBoard;
import com.sejong.cultureuniverse.repository.event.EventBoardRepository;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public Long register(EventBoardDTO dto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return null;
        }
        Admin admin = (Admin) session.getAttribute(SessionConst.LOGIN_ADMIN);
    
        EventBoard eventBoard = EventBoard.builder()
            .admin(admin)
            .eventTitle(dto.getEventTitle())
            .eventContent(dto.getEventContent())
            .readCount(0L)
            .build();
        eventBoardRepository.save(eventBoard);
        return eventBoard.getEventIdx();
    }

    @Override
    public PageResultDTO<EventBoardDTO, EventBoard> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("eventIdx").descending());

        //BooleanBuilder booleanBuilder = getSearch(requestDTO);
    
        Page<EventBoard> result = eventBoardRepository.findAllWithAdminId(pageable);
    
        Function<EventBoard, EventBoardDTO>fn = (this::entityToDto);
        return new PageResultDTO<>(result, fn);

    }

    @Override
    public EventBoardDTO read(Long eventIdx) {
        EventBoard eventBoard = eventBoardRepository.findEventBoardByEventIdx(eventIdx);
    
        return EventBoardDTO.builder()
            .eventIdx(eventBoard.getEventIdx())
            .admin(eventBoard.getAdmin())
            .eventTitle(eventBoard.getEventTitle())
            .eventContent(eventBoard.getEventContent())
            .readCount(eventBoard.getReadCount())
            .regDate(eventBoard.getRegDate())
            .modDate(eventBoard.getModDate())
            .build();
    }
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(EventBoardDTO dto) {
    
        EventBoard eventBoard = eventBoardRepository.findEventBoardByEventIdx(dto.getEventIdx());
    
        eventBoard.changeTitle(dto.getEventTitle());
        eventBoard.changeContent(dto.getEventContent());

        eventBoardRepository.save(eventBoard);

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

