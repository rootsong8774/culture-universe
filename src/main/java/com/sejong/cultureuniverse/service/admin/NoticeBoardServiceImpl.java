package com.sejong.cultureuniverse.service.admin;

import com.querydsl.core.BooleanBuilder;
import com.sejong.cultureuniverse.SessionConst;
import com.sejong.cultureuniverse.dto.NoticeBoardDetailSearchCondition;
import com.sejong.cultureuniverse.dto.admin.NoticeBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsSearchCondition;
import com.sejong.cultureuniverse.dto.performances.PerformanceListDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
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
    
    private final NoticeBoardRepository noticeBoardRepository;
    
    //admin을 찾는단계필요
    
    @Override
    public Long register(NoticeBoardDTO dto, HttpServletRequest request) {
    
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
    public PageResultDTO<NoticeBoardDTO, NoticeBoard> getList(PageRequestDTO requestDTO) {
        
        Pageable pageable = requestDTO.getPageable(Sort.by("noticeIdx").descending());
        
        Page<NoticeBoard> result = noticeBoardRepository.findAllWithAdminId(pageable);
        
        Function<NoticeBoard, NoticeBoardDTO> fn = (this::entityToDto);
        return new PageResultDTO<>(result, fn);
        
    }

    @Override
    public PageResultDTO<NoticeBoardDTO, NoticeBoard> getSearch(

        PageRequestDTO pageRequestDTO, NoticeBoardDetailSearchCondition condition) {

        Function<NoticeBoard, NoticeBoardDTO> fn = convertFromDetailsToDTO();
        Page<NoticeBoard> result = noticeBoardRepository.search(condition,
            pageRequestDTO.getPageable(Sort.by("startDate").ascending()));
        return  new PageResultDTO<>(result,fn);
    }

    @Override
    public NoticeBoardDTO read(Long noticeIdx) {
        NoticeBoard noticeBoard = noticeBoardRepository.findNoticeBoardAndAdminByNoticeIdx(
            noticeIdx);
        return NoticeBoardDTO.builder()
            .noticeIdx(noticeBoard.getNoticeIdx())
            .admin(noticeBoard.getAdmin())
            .noticeTitle(noticeBoard.getNoticeTitle())
            .noticeContent(noticeBoard.getNoticeContent())
            .readCount(noticeBoard.getReadCount())
            .regDate(noticeBoard.getRegDate())
            .modDate(noticeBoard.getModDate())
            .build();
        
    }
    private Function<NoticeBoard, NoticeBoardDTO> convertFromDetailsToDTO() {

        return (en-> entityToDto(
            NoticeBoard.builder()
                .noticeIdx(en.getNoticeIdx())
                .noticeContent(en.getNoticeContent())
                .noticeTitle(en.getNoticeTitle())
                .readCount(en.getReadCount())
                .build()
        ));
    }
    
    //업데이트 하는 항목은 제목,내용
    @Override
    public void modify(NoticeBoardDTO dto) {
    
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
    

}

