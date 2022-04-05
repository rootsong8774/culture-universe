package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.controller.NoticeBoardController;
import com.sejong.cultureuniverse.dto.NoticeBoardDto;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.NoticeBoard;
import com.sejong.cultureuniverse.repository.NoticeBoardRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public interface NoticeBoardService {
    Long register(NoticeBoardDto dto);
    PageResultDTO<NoticeBoardDto, NoticeBoard> getList(PageRequestDTO requestDTO);
    NoticeBoardDto read(Long noticeIdx);
    void modify(NoticeBoardDto dto);
    void remove(Long noticeIdx);

    default NoticeBoard dtoToEntity(NoticeBoardDto dto) {
        return NoticeBoard.builder()
            .noticeIdx(dto.getNoticeIdx())
            .noticeTitle(dto.getNoticeTitle())
            .noticeContent(dto.getNoticeContent())
            .readCount(dto.getReadCount())
            .build();
    }

    default NoticeBoardDto entityToDto(NoticeBoard entity) {

        return NoticeBoardDto.builder()
            .noticeIdx(entity.getNoticeIdx())
            .noticeTitle(entity.getNoticeTitle())
            .noticeContent(entity.getNoticeContent())
            .readCount(entity.getReadCount())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .build();
    }
}


/*    @Autowired
    private NoticeBoardRepository noticeBoardRepository;


  public NoticeBoardService(NoticeBoardRepository noticeBoardRepository) {
        this.noticeBoardRepository = noticeBoardRepository;
    }

    @Transactional
    public Long savePost(NoticeBoardDto noticeBoardDto) {
        return noticeBoardRepository.save(noticeBoardDto.toEntity()).getNoticeIdx();
    }

    @Transactional
    public List<NoticeBoardDto> getBoardList() {
        List<NoticeBoard> boardList = noticeBoardRepository.findAll();
        List<NoticeBoardDto> boardDtoList = new ArrayList<>();

        for (NoticeBoard noticeBoard : boardList) {
            NoticeBoardDto boardDto = NoticeBoardDto.builder()
                .noticeIdx(noticeBoard.getNoticeIdx())
                .adminId(noticeBoard.getAdminId())
                .noticeTitle(noticeBoard.getNoticeTitle())
                .noticeContent(noticeBoard.getNoticeContent())
                .readCount(noticeBoard.getReadCount())
                .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;

    }
}
*/

