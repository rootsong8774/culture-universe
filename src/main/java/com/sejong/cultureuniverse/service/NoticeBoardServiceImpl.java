package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.NoticeBoardAndAdminDto;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.repository.NoticeBoardRepository;

import java.time.LocalDateTime;
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
@Transactional
public class NoticeBoardServiceImpl implements NoticeBoardService {

    private final NoticeBoardRepository noticeBoardRepository;

    @Override

    public Long register(NoticeBoardAndAdminDto dto) {
        log.info("DTO---------------------------");
        log.info(dto);
        NoticeBoard entity = noticeAndAdminToEntity(dto);

        log.info(entity);

        noticeBoardRepository.save(entity);
        return entity.getNoticeIdx();
    }

    @Override
    public PageResultDTO<NoticeBoardAndAdminDto, Object[]> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("noticeIdx").descending());

        //BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<Object[]> result = noticeBoardRepository.findAllWithAdminId(pageable);

        Function<Object[], NoticeBoardAndAdminDto> fn = (en -> entityToDto(
            NoticeBoard.builder()
                .noticeIdx((Long)en[0])
                .noticeTitle((String) en[1])
                .noticeContent((String) en[2])
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
    public NoticeBoardAndAdminDto read(Long noticeIdx) {
        return noticeBoardRepository.findNoticeBoardAndAdminByNoticeIdx(
            noticeIdx);
    }

    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(NoticeBoardAndAdminDto dto) {

        NoticeBoardAndAdminDto result = noticeBoardRepository.findNoticeBoardAndAdminByNoticeIdx(
            dto.getNoticeIdx());

        result.changeTitle(dto.getNoticeTitle());
        result.changeContent(dto.getNoticeContent());
        NoticeBoard entity = noticeAndAdminToEntity(result);

        noticeBoardRepository.save(entity);
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

