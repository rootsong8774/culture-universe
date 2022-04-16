package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.QnaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminCommentServiceImpl implements AdminCommentService {
    private final AdminCommentRepository adminCommentRepository;
    private final QnaBoardRepository qnaBoardRepository;

    @Override
    public Long register(AdminCommentDTO adminCommentDTO) {
        log.info("====등록완료");
        log.info(adminCommentDTO);
        AdminComment adminComment = this.dtoToEntity(adminCommentDTO);
        log.info(adminComment);
        adminCommentRepository.save(adminComment);
        return adminComment.getCommentIdx();
    }

    @Override
    public  List<AdminCommentDTO> getList(Long questionIdx) {
        List<Object[]> result =  adminCommentRepository.getCommentOrderByQuestionIdx(questionIdx);
        List<AdminCommentDTO> result2 = result.stream().map((Function<Object[], AdminCommentDTO>)
            e->{ return AdminCommentDTO.builder()
                .commentIdx(Long.parseLong(String.valueOf(e[0])))
                .admin(Admin.builder().adminId(String.valueOf(e[1])).build())
                .commentContent(String.valueOf(e[2]))
                .regDate( (LocalDateTime) e[3]).build();
            }).collect(Collectors.toList());
        return result2;
    }

    @Transactional
    public void delete(Long commentIdx) {
        adminCommentRepository.deleteById(commentIdx);
    }
}

