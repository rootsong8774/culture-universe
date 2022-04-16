package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.dto.AdminCommentListDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.AdminComment;
import com.sejong.cultureuniverse.entity.admin.Qna;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminCommentService {

    Long register(AdminCommentDTO adminCommentDTO);
    List<AdminCommentListDTO> getList(Long commentIdx);

    void delete(Long commentIdx);
    
    

}
