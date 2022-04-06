package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.QnaBoardDTO;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.QnaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class QnaBoardServiceImpl implements QnaBoardService{
    private final QnaBoardRepository qnaBoardRepository;

    @Override
    @Transactional
    public Long register(QnaBoardDTO qnaBoardDTO) {
        log.info(qnaBoardDTO);
        Qna qna = dtoToEntity(qnaBoardDTO);
        qnaBoardRepository.save(qna);
        return qna.getQuestionIdx();
    }

    @Override
    public PageResultDTO<QnaBoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);
        Function<Object[], QnaBoardDTO> fn = (en-> entityToDto(
            Qna.builder()
                .questionIdx((Long)en[0])
                .content((String) en[1])
                .modDate((LocalDateTime) en[2])
                .regDate((LocalDateTime) en[3])
                .title((String) en[4])
                .type((String) en[5])
                .build(),
            (Member) Member.builder().userIdx((Long) en[6]).build(),
            (Long) en[7]));

        Page<Object[]> result = qnaBoardRepository.getQnaBoardWithCommentCount(
            pageRequestDTO.getPageable(Sort.by("questionIdx").descending()));
        return new PageResultDTO<>(result,fn);

    }

    @Override
    public QnaBoardDTO get(Long questionIdx) {
        Object[] result = (Object[]) qnaBoardRepository.getQnaBoardByQuestionIdx(questionIdx);
        return  entityToDto(
            Qna.builder()
                .questionIdx(Long.valueOf((Long)result[0]))
                .content((String)result[1])
                .modDate((LocalDateTime) result[2])
                .regDate((LocalDateTime) result[3])
                .title((String)result[4])
                .type((String)result[5])
                .build(),
            (Member) Member.builder().userIdx((Long) result[6]).build(),
            (Long) result[7]);
    }

}
