package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminCommentRepository;
import com.sejong.cultureuniverse.repository.QnaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AdminCommentService {

    Long register(AdminCommentDTO adminCommentDTO);
    List<Object[]> getList(Long commentIdx);
    void modify(AdminCommentDTO adminCommentDTO);
    void commentSave(Long questionIdx, AdminComment adminComment, Member member);
    void adminCommentDelete(Long commentIdx);

    default AdminComment dtoToEntity(AdminCommentDTO adminCommentDTO){
        Qna qna = Qna.builder().questionIdx(adminCommentDTO.getQna().getQuestionIdx()).build();
        Admin admin = Admin.builder().adminId(adminCommentDTO.getAdmin().getAdminId()).build();

        return AdminComment.builder()
            .commentIdx(adminCommentDTO.getCommentIdx())
            .commentContent(adminCommentDTO.getCommentContent())
            .admin(admin)
            .qna(qna)
            .build();
    }
    default AdminCommentDTO entityToDto(AdminComment adminComment){
        return AdminCommentDTO.builder()
            .commentIdx(adminComment.getCommentIdx())
            .commentContent(adminComment.getCommentContent())
            .regDate(adminComment.getRegDate())
            .modDate(adminComment.getModDate())
            .build();

    }



}
