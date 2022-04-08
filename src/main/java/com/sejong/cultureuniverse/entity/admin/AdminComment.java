package com.sejong.cultureuniverse.entity.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sejong.cultureuniverse.entity.Member;
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
    @JoinColumn(name = "user_idx")
    @ToString.Exclude
    private Member member; //회원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_idx")
//    @JsonIgnore
    @ToString.Exclude
    private Admin admin; //작성자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_idx")
//    @JsonIgnore
    @ToString.Exclude
    private Qna qna;    //문의번호


    public void save(Qna qna, Member member) {
        this.qna = qna;
        this.member = member;
    }
}
