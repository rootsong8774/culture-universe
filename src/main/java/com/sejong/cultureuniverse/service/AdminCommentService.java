package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;

import java.util.List;

public interface AdminCommentService {

    Long register(AdminCommentDTO adminCommentDTO);
    List<AdminComment> getList(Long commentIdx);
    void modify(AdminCommentDTO adminCommentDTO);
    void register(Long questionIdx, AdminComment adminComment, Member member);
    void delete(Long commentIdx);

    default AdminComment dtoToEntity(AdminCommentDTO adminCommentDTO){
         return AdminComment.builder()
            .commentIdx(adminCommentDTO.getCommentIdx())
            .commentContent(adminCommentDTO.getCommentContent())
            .admin(adminCommentDTO.getAdmin())
            .qna(adminCommentDTO.getQna())
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
