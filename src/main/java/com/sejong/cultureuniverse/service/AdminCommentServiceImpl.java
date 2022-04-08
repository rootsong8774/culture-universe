package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.QnaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCommentServiceImpl implements AdminCommentService {
    private final AdminCommentRepository adminCommentRepository;
    private final QnaBoardRepository qnaBoardRepository;

    @Override
    public Long register(AdminCommentDTO adminCommentDTO) {
        AdminComment adminComment = this.dtoToEntity(adminCommentDTO);
        adminCommentRepository.save(adminComment);
        return adminComment.getCommentIdx();
    }

    @Override
    public List<AdminComment> getList(Long questionIdx) {
        return adminCommentRepository.getCommentOrderByQuestionIdx(questionIdx);
//            result.stream().map(this::entityToDto)
//            .collect(Collectors.toList());
    }

    @Override
    public void modify(AdminCommentDTO adminCommentDTO) {
    AdminComment adminComment = dtoToEntity(adminCommentDTO);
    adminCommentRepository.save(adminComment);
    }
    @Transactional
    public void commentSave(Long questionIdx, AdminComment adminComment, Member member) {
        Qna qna = qnaBoardRepository.findById(questionIdx).orElseThrow(() ->
                new IllegalArgumentException("해당 questionIdx가 없습니다. id=" + questionIdx));

        adminComment.save(qna, member);

        adminCommentRepository.save(adminComment);
    }
    @Transactional
    public void adminCommentDelete(Long commentIdx) {
        adminCommentRepository.deleteById(commentIdx);
    }
}

