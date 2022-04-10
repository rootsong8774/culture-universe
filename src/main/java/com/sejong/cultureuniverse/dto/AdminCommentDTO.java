package com.sejong.cultureuniverse.dto;

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
    private Admin admin; //기준으로 삭제돼야함
    private Qna qna;
    private Long userIdx;

 //데이터 다 갖고 오기 위해서 한개만 선언하는것이 아닌 전체로 선언해야함.
}

