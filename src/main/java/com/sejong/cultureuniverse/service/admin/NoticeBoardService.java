package com.sejong.cultureuniverse.service.admin;

import com.querydsl.core.BooleanBuilder;
import com.sejong.cultureuniverse.dto.NoticeBoardDetailSearchCondition;
import com.sejong.cultureuniverse.dto.admin.NoticeBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.dto.performances.PerformanceDetailsSearchCondition;
import com.sejong.cultureuniverse.dto.performances.PerformanceListDTO;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.entity.performance.PerformanceDetails;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;


public interface NoticeBoardService {

    PageResultDTO<NoticeBoardDTO, NoticeBoard> getSearch(PageRequestDTO pageRequestDTO, NoticeBoardDetailSearchCondition condition);

    PageResultDTO<NoticeBoardDTO, NoticeBoard> getList(PageRequestDTO requestDTO);

    Long register(NoticeBoardDTO dto, HttpServletRequest request);

    NoticeBoardDTO read(Long noticeIdx);

    void modify(NoticeBoardDTO dto);

    void remove(Long noticeIdx);

    //db->화면
    default NoticeBoardDTO entityToDto(NoticeBoard entity) {

        return NoticeBoardDTO.builder()
            .noticeIdx(entity.getNoticeIdx())
            .noticeTitle(entity.getNoticeTitle())
            .noticeContent(entity.getNoticeContent())
            .readCount(entity.getReadCount())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .admin(entity.getAdmin())
            .build();

    }

}
