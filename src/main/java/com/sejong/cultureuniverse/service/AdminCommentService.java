package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminCommentService {

    Long register(AdminCommentDTO adminCommentDTO);
    List<AdminCommentDTO> getList(Long commentIdx);
    //    AdminCommentDTO getAdminCommentDetail(Admin admin, Qna qna);
//    void register(Long questionIdx, AdminComment adminComment, Member member);
    void delete(Long commentIdx);

    default AdminComment dtoToEntity(AdminCommentDTO adminCommentDTO){
        return AdminComment.builder()
            .commentIdx(adminCommentDTO.getCommentIdx())
            .commentContent(adminCommentDTO.getCommentContent())
            .admin(adminCommentDTO.getAdmin())
            .qna(adminCommentDTO.getQna())
            .regDate(adminCommentDTO.getRegDate())
            .modDate(adminCommentDTO.getModDate())
            .build();
    }
    default AdminCommentDTO entityToDto(AdminComment adminComment) {
        return AdminCommentDTO.builder()
            .commentIdx(adminComment.getCommentIdx())
            .admin(adminComment.getAdmin())
            .commentContent(adminComment.getCommentContent())
            .regDate(adminComment.getRegDate())
            .build();
    }

}
