package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.dto.WinnerBoardDto;
import com.sejong.cultureuniverse.entity.event.EventWinner;
import com.sejong.cultureuniverse.repository.WinnerBoardRepository;
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
public class WinnerBoardServiceImpl implements WinnerBoardService {

    private final WinnerBoardRepository winnerBoardRepository;

    @Override
    public Long register(WinnerBoardDto dto) {
        log.info("DTO---------------------------");
        log.info(dto);
        EventWinner entity = dtoToEntity(dto);

        log.info(entity);

        winnerBoardRepository.save(entity);
        return entity.getWinnerIdx();
    }

    @Override
    public PageResultDTO<WinnerBoardDto, EventWinner> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("WinnerIdx").descending());

        //BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<EventWinner> result = winnerBoardRepository.findAll(pageable);

        Function<EventWinner, WinnerBoardDto> fn = (this::entityToDto);
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public WinnerBoardDto read(Long winnerIdx) {
        Optional<EventWinner> result = Optional.ofNullable(
            winnerBoardRepository.findByWinnerIdx(winnerIdx));
        return result.map(this::entityToDto).orElse(null);
    }
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(WinnerBoardDto dto) {
        Optional<EventWinner> result = Optional.ofNullable(
            winnerBoardRepository.findByWinnerIdx(dto.getWinnerIdx()));
        if (result.isPresent()) {
            EventWinner entity = result.get();

            entity.changeTitle(dto.getWinTitle());
            entity.changeContent(dto.getWinContent());

            winnerBoardRepository.save(entity);
        }
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

