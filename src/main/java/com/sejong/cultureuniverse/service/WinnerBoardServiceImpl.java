package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.dto.WinnerBoardDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import com.sejong.cultureuniverse.repository.WinnerBoardRepository;
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
public class WinnerBoardServiceImpl implements WinnerBoardService {

    private final WinnerBoardRepository winnerBoardRepository;

    @Override
    public Long register(WinnerBoardDTO dto) {
        log.info("DTO---------------------------");
        log.info(dto);
        EventWinner entity = dtoToEntity(dto);

        log.info(entity);

        winnerBoardRepository.save(entity);
        return entity.getWinnerIdx();
    }

    @Override
    public PageResultDTO<WinnerBoardDTO, Object[]> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("winnerIdx").descending());

        //BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<Object[]> result = winnerBoardRepository.findAllWithAdminId(pageable);

        Function<Object[], WinnerBoardDTO> fn = (en -> entityToDto(
            EventWinner.builder()
                .winnerIdx((Long)en[0])
                .winTitle((String) en[1])
                .winContent((String) en[2])
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
    public WinnerBoardDTO read(Long winnerIdx) {
        return winnerBoardRepository.findEventWinnerByWinnerIdx(
            winnerIdx);
    }
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(WinnerBoardDTO dto) {
        WinnerBoardDTO result = winnerBoardRepository.findEventWinnerByWinnerIdx(
            dto.getWinnerIdx());

        result.changeTitle(dto.getWinTitle());
        result.changeContent(dto.getWinContent());
        EventWinner entity = dtoToEntity(result);

        winnerBoardRepository.save(entity);
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

