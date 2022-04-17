package com.sejong.cultureuniverse.service.admin;

import com.querydsl.core.BooleanBuilder;
import com.sejong.cultureuniverse.SessionConst;
import com.sejong.cultureuniverse.dto.admin.NoticeBoardAndAdminDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.repository.admin.AdminRepository;
import com.sejong.cultureuniverse.repository.admin.NoticeBoardRepository;

import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    
    private final AdminRepository adminRepository;
    private final NoticeBoardRepository noticeBoardRepository;
    
    //admin을 찾는단계필요
    
    @Override
    public Long register(NoticeBoardAndAdminDTO dto, HttpServletRequest request) {
    
        HttpSession session = request.getSession();
        if (session == null) {
            return null;
        }
        Admin admin = (Admin) session.getAttribute(SessionConst.LOGIN_ADMIN);
        NoticeBoard noticeBoard = NoticeBoard.builder()
            .noticeTitle(dto.getNoticeTitle())
            .noticeContent(dto.getNoticeContent())
            .readCount(0L)
            .admin(admin)
            .build();
        
        noticeBoardRepository.save(noticeBoard);
        return noticeBoard.getNoticeIdx();
    }
    
    @Override
    public PageResultDTO<NoticeBoardAndAdminDTO, NoticeBoard> getList(PageRequestDTO requestDTO) {
        
        Pageable pageable = requestDTO.getPageable(Sort.by("noticeIdx").descending());
        
        Page<NoticeBoard> result = noticeBoardRepository.findAllWithAdminId(pageable);
        
        Function<NoticeBoard, NoticeBoardAndAdminDTO> fn = (this::entityToDto);
        return new PageResultDTO<>(result, fn);
        
    }
    
    @Override
    public NoticeBoardAndAdminDTO read(Long noticeIdx) {
        NoticeBoard noticeBoard = noticeBoardRepository.findNoticeBoardAndAdminByNoticeIdx(
            noticeIdx);
        return NoticeBoardAndAdminDTO.builder()
            .noticeIdx(noticeBoard.getNoticeIdx())
            .admin(noticeBoard.getAdmin())
            .noticeTitle(noticeBoard.getNoticeTitle())
            .noticeContent(noticeBoard.getNoticeContent())
            .readCount(noticeBoard.getReadCount())
            .regDate(noticeBoard.getRegDate())
            .modDate(noticeBoard.getModDate())
            .build();
        
    }
    
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(NoticeBoardAndAdminDTO dto) {
    
        NoticeBoard noticeBoard = noticeBoardRepository.findNoticeBoardAndAdminByNoticeIdx(
            dto.getNoticeIdx());
    
        noticeBoard.changeTitle(dto.getNoticeTitle());
        noticeBoard.changeContent(dto.getNoticeContent());
       
        noticeBoardRepository.save(noticeBoard);
    }
    
    
    @Override
    public void remove(Long noticeIdx) {
        noticeBoardRepository.deleteByNoticeIdx(noticeIdx);
    }
    
    @Override
    public BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        return null;
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

