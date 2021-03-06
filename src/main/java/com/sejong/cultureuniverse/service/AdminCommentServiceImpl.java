package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.dto.AdminCommentListDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.repository.admin.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.admin.QnaBoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminCommentServiceImpl implements AdminCommentService {
    
    private final AdminCommentRepository adminCommentRepository;
    private final QnaBoardRepository qnaBoardRepository;
    private final MemberRepository memberRepository;
    
    @Override
    public Long register(AdminCommentDTO adminCommentDTO) {
        Qna qna = qnaBoardRepository.getOne(adminCommentDTO.getQuestionIdx());
        Member member = memberRepository.getOne(adminCommentDTO.getUserIdx());
        
       
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Admin admin = (Admin) authentication.getPrincipal();
        
        AdminComment adminComment = AdminComment.builder()
            .commentContent(adminCommentDTO.getCommentContent())
            .qna(qna)
            .member(member)
            .admin(admin)
            .build();
        AdminComment save = adminCommentRepository.save(adminComment);
        return save.getCommentIdx();
    }
    
    
    @Override
    public List<AdminCommentListDTO> getList(Long questionIdx) {
        return adminCommentRepository.getAdminCommentList(questionIdx);
    }
    
    @Transactional
    public void delete(Long commentIdx) {
        adminCommentRepository.deleteById(commentIdx);
    }
}

