package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminCommentDTO;
import com.sejong.cultureuniverse.dto.AdminCommentListDTO;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface AdminCommentService {

    Long register(AdminCommentDTO adminCommentDTO);
    List<AdminCommentListDTO> getList(Long questionIdx);

    void delete(Long commentIdx);
    
    

}
