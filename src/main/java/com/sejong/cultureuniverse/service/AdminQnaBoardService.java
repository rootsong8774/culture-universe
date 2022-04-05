package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminQnaBoardDTO;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.Qna;

public interface AdminQnaBoardService  {
    Long register(AdminQnaBoardDTO adminQnaBoardDTO);
    PageResultDTO<AdminQnaBoardDTO, Qna> getList (PageRequestDTO requestDTO);

    default Qna dtoToEntity(AdminQnaBoardDTO adminQnaBoardDTO) {
        Qna entity = Qna.builder()
            .title(adminQnaBoardDTO.getTitle())
            .type(adminQnaBoardDTO.getType())
            .content(adminQnaBoardDTO.getContent())
            .build();
        return entity;
    }
    default AdminQnaBoardDTO entityToDto(Qna entity){
        AdminQnaBoardDTO dto = AdminQnaBoardDTO.builder()
            .questionIdx(entity.getQuestionIdx())
            .title(entity.getTitle())
            .content(entity.getContent())
            .type(entity.getType())
            .regDate(entity.getRegDate())
            .modDate((entity.getModDate()))
            .build();
        return dto;
    }
    void modify (AdminQnaBoardDTO dto);
    AdminQnaBoardDTO read(Long questionIdx);
}