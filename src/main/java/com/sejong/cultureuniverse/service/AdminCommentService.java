package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;

public interface AdminCommentService {
    Long register(AdminCommentDTO adminCommentDTO);
    void modify(AdminCommentDTO adminCommentDTO);
    void remove(Long commentIdx);

    default AdminComment dtoToEntity(AdminCommentDTO adminCommentDTO){
        Admin admin = Admin.builder().adminId(adminCommentDTO.getAdminId()).build();
        AdminComment adminComment = AdminComment.builder()
            .commentIdx(adminCommentDTO.getCommentIdx())
            .commentContent(adminCommentDTO.getCommentContent())
            .regDate(adminCommentDTO.getRegDate())
            .modDate(adminCommentDTO.getModDate())
            .admin(admin)
            .build();
    return adminComment;
    }
    default AdminCommentDTO entityToDto(AdminComment adminComment){
        AdminCommentDTO adminCommentDTO = AdminCommentDTO.builder()
            .commentIdx(adminComment.getCommentIdx())
            .commentContent(adminComment.getCommentContent())
            .regDate(adminComment.getRegDate())
            .modDate(adminComment.getModDate())
            .build();

        return adminCommentDTO;

    }

}
