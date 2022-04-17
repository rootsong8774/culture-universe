package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.dto.QnaDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Qna;

import java.time.LocalDateTime;
import java.util.List;

public interface QnaBoardService {
    //고객 1:1 문의 등록
    Long register(QnaBoardDTO qnaBoardDTO);
    //list 페이지 만들기
    PageResultDTO<QnaBoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
    //db에서 꺼내오기
    QnaBoardDTO get(Long questionIdx);
    //vue->db
    Long register(QnaDTO qnaDTO);

    default Qna dtoToEntity(QnaBoardDTO qnaBoardDTO) {
        Member member = Member.builder()
            .userIdx(qnaBoardDTO.getUserIdx()).build();
        Qna qna = Qna.builder()
            .questionIdx(qnaBoardDTO.getQuestionIdx())
            .content(qnaBoardDTO.getContent())
            .title(qnaBoardDTO.getTitle())
            .type(qnaBoardDTO.getType())
            .member(member)
            .build();
        return qna;

    }

    default QnaBoardDTO entityToDto(Qna qna, Member member, Long commentCount) {
        QnaBoardDTO qnaBoardDTO = QnaBoardDTO.builder()
            .questionIdx(qna.getQuestionIdx())
            .userIdx(member.getUserIdx())
            .content(qna.getContent())
            .title(qna.getTitle())
            .type(qna.getType())
            .regDate(qna.getRegDate())
            .modDate(qna.getModDate())
            .commentCount(commentCount.intValue())
            .build();

        return qnaBoardDTO;
    }

   }

