package com.sejong.cultureuniverse.service.admin;

import com.sejong.cultureuniverse.dto.admin.WinnerBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import com.sejong.cultureuniverse.repository.event.WinnerBoardRepository;
import java.util.function.Function;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class WinnerBoardServiceImpl implements WinnerBoardService {
    
    private final WinnerBoardRepository winnerBoardRepository;
    
    @Override
    public Long register(WinnerBoardDTO dto) {
    
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Admin admin = (Admin) authentication.getPrincipal();
        EventWinner eventWinner = EventWinner.builder()
            .winTitle(dto.getWinTitle())
            .winContent(dto.getWinContent())
            .readCount(0L)
            .admin(admin)
            .build();
        winnerBoardRepository.save(eventWinner);
        return eventWinner.getWinnerIdx();
    }
    
    @Override
    public PageResultDTO<WinnerBoardDTO, EventWinner> getList(PageRequestDTO requestDTO) {
        
        Pageable pageable = requestDTO.getPageable(Sort.by("winnerIdx").descending());
        
        //BooleanBuilder booleanBuilder = getSearch(requestDTO);
        
        Page<EventWinner> result = winnerBoardRepository.findAllWithAdminId(pageable);
    
        Function<EventWinner, WinnerBoardDTO> fn = (this::entityToDto);
        return new PageResultDTO<>(result, fn);
        
    }
    
    @Override
    public WinnerBoardDTO read(Long winnerIdx) {
        EventWinner eventWinner = winnerBoardRepository.findEventWinnerByWinnerIdx(winnerIdx);
        return WinnerBoardDTO.builder()
            .winnerIdx(eventWinner.getWinnerIdx())
            .admin(eventWinner.getAdmin())
            .winTitle(eventWinner.getWinTitle())
            .winContent(eventWinner.getWinContent())
            .readCount(eventWinner.getReadCount())
            .regDate(eventWinner.getRegDate())
            .modDate(eventWinner.getModDate())
            .build();
    }
    
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(WinnerBoardDTO dto) {
        EventWinner eventWinner = winnerBoardRepository.findEventWinnerByWinnerIdx(
            dto.getWinnerIdx());
    
        eventWinner.changeTitle(dto.getWinTitle());
        eventWinner.changeContent(dto.getWinContent());
        
        winnerBoardRepository.save(eventWinner);
    }
    
    @Override
    public void remove(Long winnerIdx) {
        winnerBoardRepository.deleteByWinnerIdx(winnerIdx);
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

