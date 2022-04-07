package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.repository.AdminCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCommentServiceImpl implements AdminCommentService {
    private final AdminCommentRepository adminCommentRepository;

    @Override
    public Long register(AdminCommentDTO adminCommentDTO) {
        AdminComment adminComment = this.dtoToEntity(adminCommentDTO);
        adminCommentRepository.save(adminComment);
        return adminComment.getCommentIdx();
    }

    @Override
    public List<Object[]> getList(Long questionIdx) {
        List<Object[]> result = adminCommentRepository.getCommentOrderByquestionIdx(questionIdx);
        return result;
//            result.stream().map(this::entityToDto)
//            .collect(Collectors.toList());
    }

    @Override
    public void modify(AdminCommentDTO adminCommentDTO) {
    AdminComment adminComment = dtoToEntity(adminCommentDTO);
    adminCommentRepository.save(adminComment);
    }

}
