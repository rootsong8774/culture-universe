package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Qna;

public interface QnaBoardService  {
    Long register(QnaBoardDTO qnaBoardDTO);
    PageResultDTO<QnaBoardDTO, Object[]> getList (PageRequestDTO pageRequestDTO);

    QnaBoardDTO get (Long questionIdx);
//    void modify (QnaBoardDTO dto);
//    QnaBoardDTO read(Long questionIdx);
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
    default QnaBoardDTO entityToDto(Qna qna,Member member, Long commentCount){
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

