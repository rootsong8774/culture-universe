package com.sejong.cultureuniverse.dto;


import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class AdminCommentListDTO {
    
    private Long commentIdx;
    private String commentContent;
    private LocalDateTime regDate, modDate;
    private Long questionIdx;
    private String adminId;
    
    @QueryProjection
    public AdminCommentListDTO(Long commentIdx, String commentContent, LocalDateTime regDate,
        LocalDateTime modDate, Long questionIdx, String adminId) {
        this.commentIdx = commentIdx;
        this.commentContent = commentContent;
        this.regDate = regDate;
        this.modDate = modDate;
        this.questionIdx = questionIdx;
        this.adminId = adminId;
    }
}
