package com.sejong.cultureuniverse.entity.admin;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AdminComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx; //댓글 번호
    private String commentContent; //댓글 내용
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    @ToString.Exclude
    private Admin admin; //작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_idx")
    @ToString.Exclude
    private Qna qna;    //문의번호

}
