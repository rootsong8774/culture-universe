package com.sejong.cultureuniverse.dto;

import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.admin.Qna;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminCommentDTO implements Serializable {
    
    private String commentContent;
    private LocalDateTime regDate, modDate;
    private Long questionIdx;
    private Admin admin;
    private Long userIdx;
    
}

