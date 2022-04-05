package com.sejong.cultureuniverse.service;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.sejong.cultureuniverse.dto.NoticeBoardDto;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.repository.NoticeBoardRepository;
import java.util.Optional;
import java.util.function.Function;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeBoardServiceImpl implements NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;

    @Override
    @Transactional
    public Long register(NoticeBoardDto dto) {
        log.info("DTO---------------------------");
        log.info(dto);
        NoticeBoard entity = dtoToEntity(dto);

        log.info(entity);

        noticeBoardRepository.save(entity);
        return entity.getNoticeIdx();
    }

    @Override
    public PageResultDTO<NoticeBoardDto, NoticeBoard> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("noticeIdx").descending());

        //BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<NoticeBoard> result = noticeBoardRepository.findAll(pageable);

        Function<NoticeBoard, NoticeBoardDto> fn = (this::entityToDto);
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public NoticeBoardDto read(Long noticeIdx) {
        Optional<NoticeBoard> result = Optional.ofNullable(
            noticeBoardRepository.findByNoticeIdx(noticeIdx));
        return result.map(this::entityToDto).orElse(null);
    }
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(NoticeBoardDto dto) {
        Optional<NoticeBoard> result = Optional.ofNullable(
            noticeBoardRepository.findByNoticeIdx(dto.getNoticeIdx()));
        if (result.isPresent()) {
            NoticeBoard entity = result.get();

            entity.changeTitle(dto.getNoticeTitle());
            entity.changeContent(dto.getNoticeContent());

            noticeBoardRepository.save(entity);
        }
    }

    @Override
    public void remove(Long noticeIdx) {
        noticeBoardRepository.deleteByNoticeIdx(noticeIdx);
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

