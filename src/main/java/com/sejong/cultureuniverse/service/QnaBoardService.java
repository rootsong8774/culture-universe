package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.dto.paging.PageResultDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Qna;

import java.util.List;

public interface QnaBoardService {
    Long register(QnaBoardDTO qnaBoardDTO);

    PageResultDTO<QnaBoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    QnaBoardDTO get(Long questionIdx);

    QnaBoardDTO read(Long questionIdx);
    QnaBoardDTO findByComment(String comment);


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

    default  QnaBoardDTO readEntityToDto(Qna qna){
        QnaBoardDTO qnaBoardDTO = QnaBoardDTO.builder()
            .questionIdx(qna.getQuestionIdx())
            .content(qna.getContent())
            .title(qna.getTitle())
            .type(qna.getType())
            .regDate(qna.getRegDate())
            .modDate(qna.getModDate())
            .build();
        return qnaBoardDTO;
    }
}

