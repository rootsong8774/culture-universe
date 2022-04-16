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
    private Long commentIdx;
    private String commentContent;
    private LocalDateTime regDate, modDate;
    private Qna qna; // member 게시글 전부 필요
    private Admin admin; //adminId 필요
    private Member member; //userIdx 필요

}

