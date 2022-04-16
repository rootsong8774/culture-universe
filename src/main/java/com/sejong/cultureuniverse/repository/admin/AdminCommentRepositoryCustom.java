package com.sejong.cultureuniverse.repository.admin;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.dto.AdminCommentListDTO;
import java.util.List;

public interface AdminCommentRepositoryCustom {
    
    List<AdminCommentListDTO> getAdminCommentList(Long questionIdx);
}
